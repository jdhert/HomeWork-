package com.example.myfirstservlet.basic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 입력받는걸 만들고 싶다!
@WebServlet (name = "queryStringServlet", value = "/query-string-servlet")
public class QueryStringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // GET 메서드 요청을 처리
        // 쿼리스트링을 추출해야 함 :req.getParameter
        resp.setContentType("text/plain;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();

//        out.println("querystring : " + req.getQueryString());
        out.println("GET 요청\n");
        out.println(req.getParameter("name") + "\n");
        out.println(req.getParameter("city") + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("POST 요청\n");
        out.println(req.getParameter("name") + "\n");
        out.println(req.getParameter("city") + "\n");
    }

}