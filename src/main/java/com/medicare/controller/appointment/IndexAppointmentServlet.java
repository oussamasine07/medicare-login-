package com.medicare.controller.appointment;

import com.medicare.dao.AppointmentDAO;
import com.medicare.model.Appointment;
import com.medicare.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/appointment")
public class IndexAppointmentServlet extends HttpServlet {

    private AppointmentDAO appointmentDAO = null;
    private HttpSession session;
    public void init () {
        appointmentDAO = new AppointmentDAO();
    }

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {

        session = req.getSession();
        User user = (User) session.getAttribute("user");

        List<Appointment> appointments = appointmentDAO.getAppointmentsById( user.getId(), user.getRole().getType());

        System.out.println(user.getId());

        appointments.forEach(appt -> System.out.println(appt.getAppDate()));

        req.setAttribute("appointments", appointments);
        RequestDispatcher rd = req.getRequestDispatcher("/pages/appointment/index.jsp");
        rd.forward(req, res);
    }

}
