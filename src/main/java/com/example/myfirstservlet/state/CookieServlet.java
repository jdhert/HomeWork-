package com.example.myfirstservlet.state;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookieServlet", value = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 쿠키 : 클라이언트 측에 저장
        // 서버에 접속할 때 자동으로 요청에 포함되어 전달
        // 쿠키를 응답객체로 보내야 함
        Cookie cookie1 = new Cookie("id","guest");
        cookie1.setMaxAge(60 * 60 * 24); // 단위는 초단위임
        resp.addCookie(cookie1);

        Cookie cookie2 = new Cookie("code", "007");
        cookie2.setPath("/cookie-read"); //경로에 요청을 할때만 쿠키를 보낸다. 특정경로에 들어갈때만 쿠키를 보냄
        resp.addCookie(cookie2);

        out.println("쿠키 전송 완료");
    }
}
