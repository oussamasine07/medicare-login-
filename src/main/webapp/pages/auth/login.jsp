<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:include page="/pages/partials/header.jsp" />
<%@ page import="java.util.Map" %>

    <%
        // Get errors from session and remove them after displaying
        Map<String, String> errors = (Map<String, String>) session.getAttribute("errors");
        session.removeAttribute("errors");

        // Get user input from session and remove it after displaying
        com.medicare.dto.LoginDTO old = (com.medicare.dto.LoginDTO) session.getAttribute("old");
        session.removeAttribute("old");

        String errorCredentail = (String) session.getAttribute("errorCredentail");
        session.removeAttribute("errorCredentail");

    %>

    <div class="min-h-screen flex items-center justify-center w-full dark:bg-gray-950">
        <div class="bg-white dark:bg-gray-900 shadow-md rounded-lg px-8 py-6 w-2/5">

            <% if ( errorCredentail != null ) { %>
            <div id="alert-2" class="flex items-center p-4 mb-4 text-red-800 rounded-lg bg-red-50 dark:bg-gray-800 dark:text-red-400" role="alert">
              <svg class="shrink-0 w-4 h-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                <path d="M10 .5a9.5 9.5 0 1 0 9.5 9.5A9.51 9.51 0 0 0 10 .5ZM9.5 4a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3ZM12 15H8a1 1 0 0 1 0-2h1v-3H8a1 1 0 0 1 0-2h2a1 1 0 0 1 1 1v4h1a1 1 0 0 1 0 2Z"/>
              </svg>
              <span class="sr-only">Info</span>
              <div class="ms-3 text-sm font-medium">
                <%= errorCredentail %>
              </div>
              <button type="button" class="ms-auto -mx-1.5 -my-1.5 bg-red-50 text-red-500 rounded-lg focus:ring-2 focus:ring-red-400 p-1.5 hover:bg-red-200 inline-flex items-center justify-center h-8 w-8 dark:bg-gray-800 dark:text-red-400 dark:hover:bg-gray-700" data-dismiss-target="#alert-2" aria-label="Close">
                <span class="sr-only">Close</span>
                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
                </svg>
              </button>
            </div>
            <% } %>

            <h1 class="text-2xl font-bold text-center mb-4 dark:text-gray-200">Welcome Back!</h1>
            <form action="/medicare-login/auth/login" method="post">
                <div class="mb-4">
                    <label for="email" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Email Address</label>
                    <input
                        type="text"
                        id="email"
                        class="shadow-sm text-white rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                        placeholder="Your email"
                        name="email"
                        value ="<%= old != null ? old.getEmail() : "" %>"
                    >
                    <% if (errors != null && errors.containsKey("email")) { %>
                        <p class="text-red-500 text-xs italic mt-2"><%= errors.get("email") %></p>
                    <% } %>
                </div>
                <div class="mb-4">
                    <label for="password" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Password</label>
                    <input type="password" id="password" class="shadow-sm text-white rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" placeholder="Your password" name="password">
                    <% if (errors != null && errors.containsKey("password")) { %>
                        <p class="text-red-500 text-xs italic mt-2"><%= errors.get("password") %></p>
                    <% } %>
                </div>
                <div class="my-4 flex justify-center items-center">
                    <a href="#"class="text-xs text-gray-600 hover:text-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Forgot Password?</a>
                </div>
                <div class="flex items-center justify-between mb-4">
                    <div class="flex items-center">
                        <input type="checkbox" id="remember" class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500 focus:outline-none" checked>
                        <label for="remember" class="ml-2 block text-sm text-gray-700 dark:text-gray-300">Remember me</label>
                    </div>
                    <a href="#"
                        class="text-xs text-indigo-500 hover:text-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Create
                        Account</a>
                </div>
                <button type="submit" class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Login</button>
            </form>
        </div>
    </div>

<jsp:include page="/pages/partials/header.jsp" />
