package com.example.myfirstservlet.state;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher1")
public class DispatcherServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<h3> Dispatcher1 수행결과 </h3>");

        // foward (전달) 다른 서블릿으로 일을 넘길때 (서버 내부적으로 다른 서블릿 호출)
        ServletContext sc = this.getServletContext(); // 모든 서블릿을 아는 서블릿 컨텍스트
        RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");

        req.setAttribute("name", "키트리"); //<< req 객체에 저장 가능 포워드 할때 이것을 사용 가능 매우중요함
        rd.forward(req, resp); // 포워딩할때 요청정보랑 응답정보 같이 넘겨줌 아예 떠넘김
        rd.include(req, resp);  // 해당 디스패처로 경로를 처리하는 서블릿갔다가 다시 돌아옴
    }
}
