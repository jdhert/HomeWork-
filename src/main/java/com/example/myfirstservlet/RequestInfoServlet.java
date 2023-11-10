package com.example.myfirstservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "requestInfoServlet", value = "/request-info-servlet")
public class RequestInfoServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<h3>클라이언트로부터 받은 요청정보</h3>");
        out.println("<p> method : " + req.getMethod() + "</p>");
        out.println("<p> address : " + req.getRemoteAddr() + "</p>");
        out.println("<p> port : " + req.getRemotePort() + "</p>");
        out.println("<p> RequestURL : " + req.getRequestURL() + "</p>");
        out.println("<p> ContextPath : " + req.getContextPath() + "</p>");
        out.println("<p> Protocol : " + req.getProtocol() + "</p>");
        out.println("<p> ServletPath : " + req.getServletPath() + "</p>");

        out.println("<p> ServletMapping : " + req.getHttpServletMapping().getPattern() +"</p>");
        out.println("<p>헤더 정보</p>");
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()){
            String s =names.nextElement();
            out.println(s + " : " + req.getHeader(s) + "<br>");
        }


    }
}
