/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_function;

import java.sql.Connection;

/**
 *
 * @author Administrator
 */
public class MYSQLiteConnection {
     static String databaseUrl = "jdbc:mysql://localhost:3306/hoteldatabase";
    static String user ="root";
    static String password = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(databaseUrl, user, password);
            System.out.println("Connection established successfully");
        } catch (Exception e) {
            System.out.println("Error establishing connection: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        }
        return connection;
    }


    void intializeConnection() {
        try {
            System.out.println("Loading MySQL driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");
            java.sql.Connection connection = java.sql.DriverManager.getConnection(databaseUrl, user, password);
            System.out.println("Connection established successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error establishing connection: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        }
    }
    public  static  void main(String[] args) {
        MYSQLiteConnection connection = new MYSQLiteConnection();
        connection.intializeConnection();
    }
}
