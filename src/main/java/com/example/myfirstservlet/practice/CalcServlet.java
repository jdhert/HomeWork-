package com.example.myfirstservlet.practice;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calcServlet", value = "/practice/calc")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();

        out.println("<h1>계산기!!!</h1>\n");
        int num1 = Integer.parseInt(req.getParameter("val1"));
        String s = req.getParameter("op");
        int num2 = Integer.parseInt(req.getParameter("val2"));

        switch (s){
            case "plus":
                out.println("<p>" + num1 + " + " + num2 +" = " + (num1 + num2) + "</p>");
                break;
            case "minus":
                out.println("<p>" + num1 + " - " + num2 +" = " + (num1 - num2) + "</p>");
                break;
            case "mul":
                out.println("<p>" + num1 + " * " + num2 +" = " + (num1 * num2) + "</p>");
                break;
            case "div":
                out.println("<p>" + num1 + " / " + num2 +" = " + (num1 / num2) + "</p>");
                break;
            case "mod":
                out.println("<p>" + num1 + " % " + num2 +" = " + (num1 % num2) + "</p>");
                break;
            default:
                out.println("<p> test </p>");
                break;
        }

    }
}
