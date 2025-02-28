package com.medicare.controller.auth;

import com.medicare.dao.UserDAO;
import com.medicare.dto.RegisterDTO;
import com.medicare.model.User;
import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;
import com.password4j.types.Bcrypt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.IOException;

@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {

    UserDAO userDAO = null;

    public void init () {
        userDAO = new UserDAO();
    }

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {

        RequestDispatcher rd = req.getRequestDispatcher("/pages/auth/register.jsp");
        rd.forward(req, res);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse res )
        throws ServletException, IOException
    {

        User user = null;

        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        //String confirmPassword = req.getParameter("confirmPassword");

        RegisterDTO registerDTO = new RegisterDTO( fullName, email, password, role );

        Set<ConstraintViolation<RegisterDTO>> violations = validator.validate(registerDTO);
        HttpSession session = req.getSession();
        Map<String, String> errors = new HashMap<>();

        if (!violations.isEmpty()) {
            for (ConstraintViolation<RegisterDTO> violation : violations) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }

            session.setAttribute("errors", errors);
            session.setAttribute("old", registerDTO);

            res.sendRedirect("/medicare-login/auth/register");
            //TODO: make passowrd match

        } else {
            // TODO: verify if email already exists
            user = userDAO.getUserByEmail(email);
            if ( user != null ) {
                session.setAttribute("errorUser", "this email is already taken");
                res.sendRedirect("/medicare-login/auth/register");
            } else {
                // hash password
                BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);
                Hash hash = Password.hash(registerDTO.getPassword())
                        .addPepper("somethignrealyhard")
                        .with(bcrypt);
                registerDTO.setPassword(hash.getResult());
                userDAO.insertIntoUsers( registerDTO );
                session.setAttribute("registerSuccess", "Register success, Please login");
                res.sendRedirect("/medicare-login/auth/login");
            }

        }


    }
}
