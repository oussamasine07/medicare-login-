
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    <title>Home page</title>
</head>
    <%@ page import="com.medicare.model.User" %>
    <%
        User user = (User) session.getAttribute("user");
        //System.out.println(user.getFullName());
    %>

<body>

    <nav class="bg-white border-gray-200 dark:bg-gray-900">
        <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
            <a href="/medicare-login" class="flex items-center space-x-3 rtl:space-x-reverse">
                <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">MediCare</span>
            </a>
            <button data-collapse-toggle="navbar-default" type="button"
                class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
                aria-controls="navbar-default" aria-expanded="false">
                <span class="sr-only">Open main menu</span>
                <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                    viewBox="0 0 17 14">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M1 1h15M1 7h15M1 13h15" />
                </svg>
            </button>
            <div class="hidden w-full md:block md:w-auto" id="navbar-default">
                <ul
                    class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 rtl:space-x-reverse md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700 items-center">
                    <li>
                        <a href="/medicare-login"
                            class="block py-2 px-3 text-white bg-blue-700 rounded-sm md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-blue-500"
                            aria-current="page">Home</a>
                    </li>

                    <% if (user != null) { %>
                        <li>
                            <a href="#" class="block py-2 px-3 text-white bg-blue-700 rounded-sm md:bg-transparent md:p-0">Profile</a>
                        </li>
                        <li>
                            <a href="/medicare-login/appointment" class="block py-2 px-3 text-white bg-blue-700 rounded-sm md:bg-transparent md:p-0">Appointment</a>
                        </li>
                        <li>
                            <a href="/medicare-login/dashboard" class="block py-2 px-3 text-white bg-blue-700 rounded-sm md:bg-transparent md:p-0">Dashboard</a>
                        </li>
                        <li>
                            <form action="/medicare-login/auth/logout" method="post">
                                <button type="submit" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">Logout</button>
                            </form>
                        </li>
                    <% } else { %>
                        <li>
                            <a href="/medicare-login/auth/register"
                                class="block py-2 px-3 text-white bg-blue-700 rounded-sm md:bg-transparent md:p-0">Register</a>
                        </li>
                        <li>
                            <a href="/medicare-login/auth/login" class="block py-2 px-3 text-white bg-blue-700 rounded-sm md:bg-transparent md:p-0">Login</a>
                        </li>
                    <% } %>





                </ul>
            </div>
        </div>
    </nav>