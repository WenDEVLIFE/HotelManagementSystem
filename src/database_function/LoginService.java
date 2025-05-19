package database_function;

import javax.swing.*;

public class LoginService {

    private static volatile  LoginService instance;

    public static LoginService getInstance() {
        if (instance == null) {
            synchronized (LoginService.class) {
                if (instance == null) {
                    instance = new LoginService();
                }
            }
        }
        return instance;
    }

    public void Login(String username, String password){
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            java.sql.ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                 String role = resultSet.getString("role");
                 int userId = resultSet.getInt("user_id");
                JOptionPane.showMessageDialog(null, "Login successful. Welcome " + username + "!");
                System.out.println("Login successful.");
            } else {
                System.out.println("Invalid username or password.");
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
    }
    }
}
