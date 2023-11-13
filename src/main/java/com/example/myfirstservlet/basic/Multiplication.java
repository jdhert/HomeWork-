package com.example.myfirstservlet.basic;

// 구구단 클래스


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "multiplication", value ="/multiplication")
public class Multiplication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();

        out.println("구구단!!\n");
        int num = Integer.parseInt(req.getParameter("firstname"));
        out.println("<h4>" + num + "단</h4>");
        for (int i = 1; i < 10; i++) {
            out.println("<p>" + num + " * " + i +" = " + num * i + "</p>");
        }
    }
}
