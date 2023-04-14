package com.example.chifoumi2;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEBINF/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if (username.equals("cyp") && password.equals("cypcyp")) {
        HttpSession session = req.getSession();
        session.setAttribute("username", "cyp");
        resp.sendRedirect(req.getContextPath() + "/secured");
    } else {
        req.setAttribute("iserror", true);
        req.getRequestDispatcher("/WEBINF/login.jsp").forward(req,resp);
    }

}
}


