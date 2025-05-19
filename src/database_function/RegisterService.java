package database_function;

import UI.SignUp;

import javax.swing.*;

public class RegisterService {

    private static volatile  RegisterService instance;

    public static RegisterService getInstance() {
        if (instance == null) {
            synchronized (RegisterService.class) {
                if (instance == null) {
                    instance = new RegisterService();
                }
            }
        }
        return instance;
    }

    public boolean isUserExist(String username){
        // Check if the user already exists in the database
        String query = "SELECT * FROM users WHERE username = ?";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            java.sql.ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if a record is found
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void InsertUser(String username, String password) {
        // Insert the new user into the database
        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, "user");

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User registered successfully.");
                JOptionPane.showMessageDialog(null, "User registered successfully.");
            } else {
                System.out.println("Failed to register user.");
                JOptionPane.showMessageDialog(null, "Failed to register user.");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
