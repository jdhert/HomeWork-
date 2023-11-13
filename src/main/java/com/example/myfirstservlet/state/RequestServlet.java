package com.example.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestServlet", value = "/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 : HttpServletRequest 객체 생성
        // 응답 : HttpServletRequest 객체 소멸
        String site = req.getParameter("site");
        switch (site) {
            case "naver":
                //네이버로 이동 (리다이렉트) 재지정
                resp.sendRedirect("https://www.naver.com");
                break;
            case "google":
                resp.sendRedirect("https://www.google.com");
                break;
            case "daum":
                resp.sendRedirect("https://www.daum.net");
                break;
        }
    }
}
