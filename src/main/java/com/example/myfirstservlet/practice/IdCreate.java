package com.example.myfirstservlet.practice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/practice/id-create")
public class IdCreate extends HttpServlet {
    HashMap<String, String> Id = new HashMap<>();

    ServletContext sc;

    @Override
    public void init(ServletConfig config) {
        //ServletContext : LifeCycle WAS 시작부터 끝날때까지
        sc = config.getServletContext(); //1. config 객체 통해서 서블릿 컨텍스트 가져올수 있음
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("ID");
        String password = req.getParameter("password");
        String passwordVerify = req.getParameter("passwordVerify");
        if (id == null || password == null || passwordVerify == null) {
            out.println("입력값이 올바르지 않습니다.");
        }else if(Id.containsKey(id))
            out.println("이미 존재하는 회원입니다.");
        else if(!password.equals(passwordVerify))
            out.println("비밀번호가 일치하지 않습니다.");
        else {
            Id.put(id, password);
            sc.setAttribute("IdData", Id);
            req.getRequestDispatcher("loginOut.html").forward(req, resp);
        }
    }
}
