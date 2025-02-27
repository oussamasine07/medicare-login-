package com.medicare.controller.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void init () {}

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        RequestDispatcher rd = req.getRequestDispatcher("/pages/auth/login.jsp");
        rd.forward(req, res);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse res )
        throws ServletException, IOException
    {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // validate empty fields
        // validate if email exists
        // validate password
        // authenticate user and redirect


        if (email.equals("info@example.com") && password.equals("123")) {
            HttpSession session = req.getSession();
            session.setAttribute("user", "oussama");
            res.sendRedirect( req.getContextPath() + "/dashboard");
        } else {
            res.sendRedirect(req.getContextPath() + "/auth/login");
        }
    }
}


















