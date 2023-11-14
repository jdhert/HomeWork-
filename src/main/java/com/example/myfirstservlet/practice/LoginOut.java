package com.example.myfirstservlet.practice;

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

    boolean check;

    public void init() {
        check =true;
        sc = this.getServletContext();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();

        if(!check) {
            out.println("로그아웃 되었습니다.");
            this.getServletContext().setAttribute("sessionCheck", req.getSession());
            check =true;
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
        Id = (HashMap<String, String>) this.getServletContext().getAttribute("IdData");
        String id = req.getParameter("ID");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        if(session.isNew()){ // 최초로 생성된 세션이냐?
            check = true; //
        }
        if (id == null || password == null)
            out.println("입력값이 올바르지 않습니다.");
        else if (Id.containsKey(id) && Id.get(id).equals(password) && check) {
                check =false;
                out.println("로그인 성공 했습니다.");
//                HttpSession session = req.getSession();
//                this.getServletContext().setAttribute("sessionCheck", session);
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
