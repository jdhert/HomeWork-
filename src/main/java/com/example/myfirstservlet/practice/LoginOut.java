package com.example.myfirstservlet.practice;

import com.example.myfirstservlet.state.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/practice/loginOut")
public class LoginOut extends HttpServlet {
    HashMap<String, String> Id = new HashMap<>();
    ServletContext sc;
    HashMap<HttpSession, String> sessionStringHashMap = new HashMap<>();


    public void init() {
        sc = this.getServletContext();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(true);
        if(sessionStringHashMap.containsKey(session)) {
            sessionStringHashMap.remove(session);
            out.println("로그아웃 되었습니다.");
            out.println("<br>\n" +
                    "<a href=\"loginOut.html\">다시 로그인하기</a>");
        } else {
            out.println("현재 로그인 상태가 아닙니다.");
            out.println("<br>\n" +
                    "<a href=\"loginOut.html\">다시 로그인하기</a>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();
        Id = (HashMap<String, String>) sc.getAttribute("IdData");
        String id = req.getParameter("ID");
        String password = req.getParameter("password");
        HttpSession session = req.getSession(true);

        if (id == null || password == null)
            out.println("입력값이 올바르지 않습니다.");
        else if (Id.containsKey(id) && Id.get(id).equals(password) && !sessionStringHashMap.containsKey(session)) {
            if(!sessionStringHashMap.containsValue(id)) {
                sessionStringHashMap.put(session, id);
                out.println("로그인 성공 했습니다.");
            } else out.println("이미 로그인된 사용자입니다.");
        }
        else if(!Id.containsKey(id))
            out.println("해당 회원 ID는 존재하지 않습니다.");
        else if(!Id.get(id).equals(password))
            out.println("비밀번호가 틀렸습니다.");
        else {
            out.println("현재 로그인 상태입니다.");
        }

    }

}
