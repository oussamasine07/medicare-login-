<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:include page="/pages/partials/header.jsp" />
<%@ page import="java.util.Map" %>

    <%
        // Get errors from session and remove them after displaying
        Map<String, String> errors = (Map<String, String>) session.getAttribute("errors");
        //System.out.println("errors are" + errors);
        session.removeAttribute("errors");

        // Get user input from session and remove it after displaying
        com.medicare.dto.RegisterDTO old = (com.medicare.dto.RegisterDTO) session.getAttribute("old");
        session.removeAttribute("old");
    %>

    <div class="min-h-screen flex items-center justify-center w-full dark:bg-gray-950">
        <div class="bg-white dark:bg-gray-900 shadow-md rounded-lg px-8 py-6 w-2/5">
            <h1 class="text-2xl font-bold text-center mb-4 dark:text-gray-200">Welcome to the app</h1>
            <form action="/medicare-login/auth/register" method="POST">
                <div class="mb-4">
                    <label for="full-name" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Full Name</label>
                    <input
                        type="text" id="full-name"
                        class="shadow-sm text-white rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" placeholder="Your full name"
                        name="fullName"
                        value ="<%= old != null ? old.getFullName() : "" %>"
                    >
                    <% if (errors != null && errors.containsKey("fullName")) { %>
                        <p class="text-red-500 text-xs italic mt-2"><%= errors.get("fullName") %></p>
                    <% } %>
                </div>
                <div class="mb-4">
                    <label for="email" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Email Address</label>
                    <input
                        type="text" id="email"
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
                    <label for="password-cofirm" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Choose role</label>
                    <select class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name="role">
                          <option value="">Role</option>
                          <option value="doctor">Doctor</option>
                          <option value="patient">Patient</option>
                    </select>
                    <% if (errors != null && errors.containsKey("confirmPassword")) { %>
                        <p class="text-red-500 text-xs italic mt-2"><%= errors.get("confirmPassword") %></p>
                    <% } %>
                </div>
                <div class="mb-4">
                    <label for="password" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Password</label>
                    <input type="password" id="password" class="shadow-sm text-white rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" name="password" placeholder="Your password" >
                    <% if (errors != null && errors.containsKey("password")) { %>
                        <p class="text-red-500 text-xs italic mt-2"><%= errors.get("password") %></p>
                    <% } %>
                </div>

                <a href="#" class="text-xs text-gray-600 hover:text-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 block mb-4">Forgot
                    Password?</a>
                <div class="flex items-center justify-between mb-4">
                    <div class="flex items-center">
                        <input type="checkbox" id="remember" class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500 focus:outline-none" checked>
                        <label for="remember" class="ml-2 block text-sm text-gray-700 dark:text-gray-300">Remember me</label>
                    </div>
                    <a href="#"
                        class="text-xs text-indigo-500 hover:text-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Create
                        Account</a>
                </div>
                <button type="submit" class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Register</button>
            </form>
        </div>
    </div>

<jsp:include page="/pages/partials/header.jsp" />
