package com.medicare.dao;


import com.medicare.model.Appointment;
import com.medicare.model.Doctor;
import com.medicare.model.Patient;
import com.medicare.model.User;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO extends ConnectToDB {

    private static final String APPOINTMENTS_BY_PATIENT_ID = "SELECT * FROM appointments\n" +
            "WHERE patient_id = ?;";
    private static final String APPOINTMENTS_BY_DOCTOR_ID = "SELECT * FROM appointments\n" +
            "WHERE doctor_id = ?;";

    private DoctorDAO doctorDAO = new DoctorDAO();
    private PatientDAO patientDAO = new PatientDAO();


    public List<Appointment> getAppointmentsById ( int userId, String type ) {
        ArrayList<Appointment> appointments = new ArrayList<>();
        String STATMENT_TYPE = type.equals("doctor") ? APPOINTMENTS_BY_DOCTOR_ID : APPOINTMENTS_BY_PATIENT_ID;

        try (
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(STATMENT_TYPE);
        ){
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            System.out.println(stmt.toString());

            while (rs.next()) {
                int id = rs.getInt("id");
                int doctorId = rs.getInt("doctor_id");
                int patientId = rs.getInt("patient_id");
                String appDate = rs.getString("appDate");
                String appTime = rs.getString("appTime");
                String motif = rs.getString("motif");
                boolean isCanceled = rs.getBoolean("is_canceled");
                boolean isDone = rs.getBoolean("is_done");

                Doctor doctor = doctorDAO.getDoctorById(doctorId);
                Patient patient = patientDAO.getPatientById(patientId);

                System.out.println(appDate);

                Appointment appointment = new Appointment(id, patient, doctor, appDate, appTime, motif, isCanceled, isDone);

                appointments.add(appointment);

            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }

        return appointments;
    }

}
