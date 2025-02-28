package com.medicare.dao;

import com.medicare.dto.RegisterDTO;
import com.medicare.model.Doctor;
import com.medicare.model.Patient;
import com.medicare.model.Role;
import com.medicare.model.User;

import java.sql.*;

public class UserDAO extends ConnectToDB {

    private static final String INSERT_INTO_USERS = "INSERT INTO users (fullName, email, password, role) VALUES (?, ?, ?, ?);";
    private static final String ADD_DOCTOR = "INSERT INTO doctors (user_id) values (?);";
    private static final String ADD_PATIENT = "INSERT INTO patients (user_id) values (?);";
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";


    public void insertIntoUsers (RegisterDTO register ) {

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, register.getFullName());
            stmt.setString(2, register.getEmail());
            stmt.setString(3, register.getPassword());
            stmt.setString(4, register.getRole());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {  // Ensure there's a result before accessing it
                int userId = rs.getInt(1); // Typically, the first column returned is the generated id
                if ("doctor".equals(register.getRole())) addDoctor(userId);
                if ("patient".equals(register.getRole())) addPatient(userId);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addDoctor ( int doctorId ) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_DOCTOR);
        ){
            stmt.setInt(1, doctorId);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPatient ( int patientId ) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_PATIENT);
        ){
            stmt.setInt(1, patientId);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByEmail ( String email ) {
        User user = null;
        try (
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(GET_USER_BY_EMAIL);
        ){
           stmt.setString(1, email);
           ResultSet rs = stmt.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               String name = rs.getString("fullName");
               String userEmail = rs.getString("email");
               String role = rs.getString("role");
               String password = rs.getString("password");
               user = role.equals("doctor") ? new Doctor(id, name, userEmail, password, new Role( role )) : new Patient(id, name, userEmail, password, new Role( role ));
           }
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        return user;
    }
}
