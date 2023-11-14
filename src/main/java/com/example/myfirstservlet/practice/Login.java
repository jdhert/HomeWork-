package com.example.myfirstservlet.practice;

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

@WebServlet("/practice/log-in")
public class Login extends HttpServlet {
    HashMap<String, String> Id = new HashMap<>();
    ServletContext sc;
    public void init() {
        //ServletContext : LifeCycle WAS 시작부터 끝날때까지
        sc = this.getServletContext();
        sc.setAttribute("Check", true );
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();
        Id = (HashMap<String, String>) this.getServletContext().getAttribute("IdData");
        String id = req.getParameter("ID");
        String password = req.getParameter("password");
        boolean ck = (boolean) this.getServletContext().getAttribute("Check");
        if (id == null || password == null) {
            out.println("입력값이 올바르지 않습니다.");
        }else if (Id.containsKey(id) && Id.get(id).equals(password) && ck) {
                out.println("로그인 성공 했습니다.");
                this.getServletContext().setAttribute("Check",false);
        }
        else if(!Id.containsKey(id))
            out.println("해당 회원 ID는 존재하지 않습니다.");
        else if(!Id.get(id).equals(password)){
            out.println("비밀번호가 틀렸습니다.");
        } else{
            out.println("이미 로그인 중입니다.");
        }
    }

}
