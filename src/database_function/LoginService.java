package database_function;

import UI.AdminFrame;
import UI.Login;
import UI.UserFrame;

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

    public void Login(String username, String password, Login login){
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            java.sql.ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                 String role = resultSet.getString("role");
                 int userId = resultSet.getInt("user_id");

                 if (role.toLowerCase().equals("admin")){
                     AdminFrame adminFrame = new AdminFrame();
                        adminFrame.setVisible(true);
                        adminFrame.setResizable(false);
                        adminFrame.setLocationRelativeTo(null);
                        adminFrame.setTitle("Admin");
                        login.dispose();
                 }
                 if (role.toLowerCase().equals("user")){
                     UserFrame userFrame = new UserFrame(userId);
                        userFrame.setVisible(true);
                        userFrame.setResizable(false);
                     userFrame.setTitle("User - My Check In Details");
                        userFrame.setLocationRelativeTo(null);
                        login.dispose();

                 }
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
