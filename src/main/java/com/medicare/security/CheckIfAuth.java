package com.medicare.security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class CheckIfAuth implements Filter {
    private HttpServletRequest httpReq;
    private HttpServletResponse httpRes;
    private static final String[] requiredUrlPages = {
            "/dashboard",
            "/profile"
    };
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        httpReq = (HttpServletRequest) request;
        httpRes = (HttpServletResponse) response;

        String path = httpReq.getRequestURI().substring(httpReq.getContextPath().length());

//        if (path.startsWith("/auth/")) {
//            chain.doFilter(request, response);
//            return;
//        }

        HttpSession session = httpReq.getSession(false);
        boolean isLoggedInUser = (session != null && session.getAttribute("user") != null);

        String loginURI = httpReq.getContextPath() + "/auth/login";
        String registerURI = httpReq.getContextPath() + "/auth/register";
        boolean isAuthRequest = (httpReq.getRequestURI().equals(loginURI) || httpReq.getRequestURI().equals(registerURI));
        boolean isAuthPage = (httpReq.getRequestURI().endsWith("/login") || httpReq.getRequestURI().endsWith("/register"));
//        String loginPage = httpReq.getRequestURI();

//        System.out.println("-----------------------------------------------");
//        System.out.println("login uri " + loginURI);
//        System.out.println("-----------------------------------------------");
//
//        System.out.println("is loged in " + isLoggedInUser);
//        System.out.println("is login request " + isLoginRequest);
//        System.out.println("login page " + loginPage);
//        System.out.println("is login page " + isLoginPage);

//        && (isLoginRequest || isLoginPage)

        if ( isLoggedInUser && (isAuthRequest || isAuthPage) ) {
            System.out.println("check if user already logged in ");
            httpRes.sendRedirect(httpReq.getContextPath() + "/dashboard");
        }
        else if ( !isLoggedInUser && isLoggedInRequired() ) {
            System.out.println("check user not logged in");
            httpRes.sendRedirect(httpReq.getContextPath() + "/auth/login");
        } else {
            System.out.println("redirect even id logged in or not");
            chain.doFilter(request, response);
        }

    }

    private boolean isLoggedInRequired () {
        String requestURL = httpReq.getRequestURL().toString();
        for (String requiredUrlPage : requiredUrlPages) {
            if (requestURL.contains(requiredUrlPage)) {
                return true;
            }
        }
        return false;
    }

    public void init ( FilterConfig fConfig ) {

    }
}
