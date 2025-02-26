package com.medicare.controller.auth;

import com.medicare.dto.RegisterDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.*;

import java.util.Set;
import java.util.stream.Collector;
import java.io.IOException;

@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void init () {}

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        RequestDispatcher rd = req.getRequestDispatcher("/pages/auth/register.jsp");
        rd.forward(req, res);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse res )
        throws ServletException, IOException
    {

        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        RegisterDTO registerDTO = new RegisterDTO( fullName, email, password, confirmPassword );

        Set<ConstraintViolation<RegisterDTO>> violations = validator.validate(registerDTO);

        if (!violations.isEmpty()) {
            violations.forEach(err -> System.out.println(err));
        }

        res.sendRedirect("/medicare-login/auth/register");



    }
}
