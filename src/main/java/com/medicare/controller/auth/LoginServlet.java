package com.medicare.controller.auth;

import com.medicare.dao.UserDAO;
import com.medicare.dto.LoginDTO;
import com.medicare.dto.RegisterDTO;
import com.medicare.model.User;
import com.password4j.BcryptFunction;
import com.password4j.Password;
import com.password4j.types.Bcrypt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    UserDAO userDAO = null;
    public void init () {
        userDAO = new UserDAO();
    }

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

        BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);


        // validate fields
        LoginDTO loginDTO = new LoginDTO(email, password);
        Set<ConstraintViolation<LoginDTO>> violations = validator.validate(loginDTO);
        HttpSession session = req.getSession();
        Map<String, String> errors = new HashMap<>();

        if (!violations.isEmpty()) {
            System.out.println("errors are not empty");
            for ( ConstraintViolation<LoginDTO> violation : violations ) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }

            session.setAttribute("errors", errors);
            session.setAttribute("old", loginDTO);

            res.sendRedirect("/medicare-login/auth/login");

        } else {
            // validate if email exists
            User user = userDAO.getUserByEmail(email);
            if ( user == null ) {
                session.setAttribute("userNotFound", "this user is not found");
                res.sendRedirect("/medicare-login/auth/login");
            } else {
                // validate password
                boolean isMatch = Password.check(password, user.getPassword())
                        .addPepper("somethignrealyhard")
                        .with(bcrypt);
                if ( !isMatch ) {
                    session.setAttribute("pwErr", "Invalid credentials");
                    res.sendRedirect("/medicare-login/auth/login");
                } else {
                    // authenticate user and redirect
                    session.setAttribute("user", user);
                    res.sendRedirect(req.getContextPath() + "/dashboard");
                }
            }

        }



//        if (email.equals("info@example.com") && password.equals("123")) {
//            HttpSession session = req.getSession();
//            session.setAttribute("user", "oussama");
//            res.sendRedirect( req.getContextPath() + "/dashboard");
//        } else {
//            res.sendRedirect(req.getContextPath() + "/auth/login");
//        }
    }
}


















