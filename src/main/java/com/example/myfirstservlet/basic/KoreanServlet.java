package com.example.myfirstservlet.basic;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "koreanServlet",value = "/korean-servlet")
public class KoreanServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 클라이언트에 문자열로 응답 -> 출력 스트림
        resp.setContentType("text/html;charset=UTF-8"); //charset 변경
        PrintWriter out = resp.getWriter();
        out.println("<h1>안녕하세요</h1>");
    }  // 메시지 상관없이 다 실행
}
