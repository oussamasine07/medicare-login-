package com.medicare.dao;

import com.medicare.model.Doctor;
import com.medicare.model.User;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAO extends ConnectToDB {

    private static final String GET_DOCTOR_BY_ID = "SELECT * FROM doctors\n" +
            "WHERE id = ?;";

    private HttpSession session;

    public Doctor getDoctorById ( int id ) {
        Doctor doctor = null;
        User user = (User) session.getAttribute("user");
        try (
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(GET_DOCTOR_BY_ID);
        ){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while ( rs.next() ) {
                String specialty = rs.getString("specialty");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                doctor = new Doctor(user.getId(), user.getFullName(), user.getEmail(), user.getRole());
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }

        return doctor;
    }

}
