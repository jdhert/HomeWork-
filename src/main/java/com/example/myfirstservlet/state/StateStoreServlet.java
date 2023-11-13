package com.example.myfirstservlet.state;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "stateStoreServlet", value = "/state-store")
public class StateStoreServlet extends HttpServlet {
    int memberCount = 0; // 필드 (멤버변수)
    ServletContext servletContext = null;

    HashMap<HttpSession, Integer> users = new HashMap<>();

    // init은 서블릿이 최초 생성될 때 딱 1번 실행
    @Override
    public void init(ServletConfig config) {
        //ServletContext : LifeCycle WAS 시작부터 끝날때까지
        servletContext = config.getServletContext(); //1. config 객체 통해서 서블릿 컨텍스트 가져올수 있음
        servletContext.setAttribute("count", 0);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int localCount = 0; // 지역 변수
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("멤버변수 카운트 : " + ++memberCount);
        out.println("로컬변수 카운트 : " + ++localCount);

        //ServletContext 서블릿을 담고 있는 관리객체
        int applicationCount = (int) servletContext.getAttribute("count");
//        int applicationCount2 = (int) this.getServletContext().getAttribute("count");
        servletContext.setAttribute("count", ++applicationCount);
        out.println("애플리케이션 단위 카운트 : " + applicationCount);

//        this.getServletContext(); // 2번째 방법 서블릿 컨텍스트 가져온 방법 (부모의 메서드로 가져온것)

        // Session << HttpServletRequest req에서 세션을 가져옴 클라이언트 요청부터 클라이언트 종료까지(웹브라우저 종료)
        HttpSession session = req.getSession(); // 클라이언트마다 고유한 세션 ID 가져오는 것 << 최초요청시 생성
        if(session.isNew()){ // 최초로 생성된 세션이냐?
            out.println("세션 생성 완료 " + session.getId()); // 세션 ID 추출
        }
        Integer sessionCount = (Integer) session.getAttribute("count");
        if(sessionCount == null){
            sessionCount = 0;
            session.setAttribute("count", sessionCount);
        }
        session.setAttribute("count", ++sessionCount);
        out.println("세션 단위 카운트 : " + sessionCount);
        out.println("--- 해당 페이지에 접속한 유저별 방문 횟수 ---");
        users.put(session, sessionCount);
        users.forEach((key, value) -> out.println(key + " : " + value));

    }
}
