package com.medicare.dao;

import com.medicare.model.Doctor;
import com.medicare.model.Patient;
import com.medicare.model.User;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO extends ConnectToDB {
    private static final String GET_PATIENT_BY_ID = "SELECT * FROM patients\n" +
            "WHERE id = ?;";

    private HttpSession session;

    public Patient getPatientById (int id ) {
        Patient patient = null;
        User user = (User) session.getAttribute("user");
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_PATIENT_BY_ID);
        ){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while ( rs.next() ) {
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                patient = new Patient(user.getId(), user.getFullName(), user.getEmail(), user.getRole());
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }

        return patient;
    }
}
