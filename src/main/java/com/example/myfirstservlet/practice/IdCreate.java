package com.example.myfirstservlet.practice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/id-create")
public class IdCreate extends HttpServlet {
    HashMap<String, String> Id = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("Id");
        String password = req.getParameter("password");
        String passwordVerify = req.getParameter("passwordVerify");
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/log-in");

        if(!Id.containsKey(id) && password.equals(passwordVerify)){
            Id.put(id, password);
            req.setAttribute("IdData", Id);
            rd.forward(req,resp);
        }

    }
}
