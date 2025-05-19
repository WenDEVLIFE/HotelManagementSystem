package database_function;

import java.util.List;

import javax.swing.*;
import model.AccountModel;

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

    public void InsertUser(String username, String password, String role) {
        // Insert the new user into the database
        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);

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

    public void deleteUser(String userID) {
        String query = "DELETE FROM users WHERE userID = ?";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userID);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User deleted successfully.");
                JOptionPane.showMessageDialog(null, "User deleted successfully.");
            } else {
                System.out.println("Failed to delete user.");
                JOptionPane.showMessageDialog(null, "Failed to delete user.");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AccountModel> getAllUsers() {

        String query = "SELECT * FROM users";
        List<AccountModel> userList = new java.util.ArrayList<>();

        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query);
             java.sql.ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String userID = resultSet.getString("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");

                AccountModel user = new AccountModel(userID, username, password, role);
                userList.add(user);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();

        }
   
        return userList;
    }

    public void updateUser(String userID, String newUsername, String newPassword, String newRole) {

        String query = "UPDATE users SET username = ?, password = ?, role = ? WHERE user_id = ?";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            statement.setString(3, newRole);
            statement.setString(4, userID);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User updated successfully.");
                JOptionPane.showMessageDialog(null, "User updated successfully.");
            } else {
                System.out.println("Failed to update user.");
                JOptionPane.showMessageDialog(null, "Failed to update user.");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
