package com.example.myfirstservlet.practice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/practice/log-out")
public class LogOut extends HttpServlet {
    ServletContext sc1;
    public void init() {
        sc1 = this.getServletContext();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();
        boolean ck = (boolean) sc1.getAttribute("Check");
        if(!ck) {
            out.println("로그아웃 되었습니다.");
            sc1.setAttribute("Check", true);
        } else out.println("현재 로그인 상태가 아닙니다.");
    }
}
