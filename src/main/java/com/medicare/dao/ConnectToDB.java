package com.medicare.dao;

//import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

//    private Dotenv dotenv = Dotenv
//            .configure()
//            .directory("./")
//            .filename(".env")
//            .load();


    private final String dbURI = "jdbc:mysql://localhost:3306/medicare_login?useSSL=false";
    private final String dbUsername = "root";
    //private String dbPassword = dotenv.get("DATABASE_PASSWORD");
    private final String dbPassword = "Climbing0673!";

    protected Connection getConnection () {
//        System.out.println(dbPassword);
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURI, dbUsername, dbPassword);
            System.out.println("database connected");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return con;
    }

}
