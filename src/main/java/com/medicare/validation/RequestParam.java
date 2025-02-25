package com.medicare.validation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class RequestParam {

    private static ArrayList<InputError> errors = new ArrayList<>();

    public static void params (HttpServletRequest req, HttpServletResponse res ) {

        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");



    }

}
