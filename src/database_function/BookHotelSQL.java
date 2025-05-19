package database_function;

import UI.AdminFrame;
import UI.CheckInForm;
import UI.CheckOutForm;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class BookHotelSQL {

    private static volatile  BookHotelSQL instance;

    public static BookHotelSQL getInstance(){
        if (instance == null) {
            synchronized (BookHotelSQL.class) {
                if (instance == null) {
                    instance = new BookHotelSQL();
                }
            }
        }
        return instance;
    }


    public void addCheckInDetails(Map<String, Object> checkInDetails, CheckInForm checkInForm) {
        String getUserIdQuery = "SELECT user_id FROM users WHERE username = ?";
        String insertQuery = "INSERT INTO check_in_table (user_id, customer_name, room_id, no_of_person, date_in, date_out, no_of_nights, advance_payment, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String reportSQL = "INSERT INTO report (description, date, time) VALUES (?, ?, ?)";
        String updateRoomStatusSQL = "UPDATE room SET room_status = 'Occupied' WHERE room_id = ?";
        String roomIdQuery = "SELECT room_id FROM room WHERE room_id = ?";

        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement getUserIdStmt = connection.prepareStatement(getUserIdQuery);
             java.sql.PreparedStatement roomIdStmt = connection.prepareStatement(roomIdQuery);
             java.sql.PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
             java.sql.PreparedStatement reportStmt = connection.prepareStatement(reportSQL);
             java.sql.PreparedStatement updateRoomStatusStmt = connection.prepareStatement(updateRoomStatusSQL)) {

            // Retrieve user_id
            getUserIdStmt.setString(1, (String) checkInDetails.get("accountName"));
            java.sql.ResultSet userResultSet = getUserIdStmt.executeQuery();

            if (userResultSet.next()) {
                int userId = userResultSet.getInt("user_id");

                // Retrieve room_id
                roomIdStmt.setString(1, (String) checkInDetails.get("roomNumber"));
                java.sql.ResultSet roomResultSet = roomIdStmt.executeQuery();

                if (roomResultSet.next()) {
                    String roomId = roomResultSet.getString("room_id");

                    // Insert check-in details
                    insertStmt.setInt(1, userId);
                    insertStmt.setString(2, (String) checkInDetails.get("customerName"));
                    insertStmt.setString(3, roomId);
                    insertStmt.setString(4, (String) checkInDetails.get("noOfPerson"));
                    insertStmt.setString(5, (String) checkInDetails.get("dateIn"));
                    insertStmt.setString(6, (String) checkInDetails.get("dateOut"));
                    insertStmt.setString(7, (String) checkInDetails.get("noOfNights"));
                    insertStmt.setString(8, (String) checkInDetails.get("advancePayment"));
                    insertStmt.setString(9, (String) checkInDetails.get("balance"));

                    int rowsAffected = insertStmt.executeUpdate();

                    if (rowsAffected > 0) {
                        // Update room status
                        updateRoomStatusStmt.setString(1, roomId);
                        updateRoomStatusStmt.executeUpdate();

                        // Insert into report table
                        LocalTime currentTime = LocalTime.now();
                        LocalDate currentDate = LocalDate.now();
                        reportStmt.setString(1, "Check-in details added for customer name " + checkInDetails.get("customerName"));
                        reportStmt.setString(2, currentDate.toString());
                        reportStmt.setString(3, currentTime.toString());

                        int reportRowsAffected = reportStmt.executeUpdate();

                        if (reportRowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Check-in details added successfully.");
                            AdminFrame adminFrame = new AdminFrame();
                            adminFrame.setVisible(true);
                            adminFrame.setResizable(false);
                            adminFrame.setLocationRelativeTo(null);
                            checkInForm.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add report entry.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add check-in details.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Room not found. Please check the room number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "User not found. Please check the account name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCheckOutDetails(Map<String, Object> checkOutDetails, CheckOutForm checkOutForm) {
        String getUserIdQuery = "SELECT user_id FROM users WHERE username = ?";
        String insertQuery = "INSERT INTO check_out_table (user_id, guest_name, room_id, no_of_person, date_in, date_out, rate, total_change, other_charges, total, amount, no_of_days ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String reportSQL = "INSERT INTO report (description, date, time) VALUES (?, ?, ?)";
        String updateRoomStatusSQL = "UPDATE room SET room_status = 'Available' WHERE room_id = ?";
        String roomIdQuery = "SELECT room_id FROM room WHERE room_id = ?";

        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement getUserIdStmt = connection.prepareStatement(getUserIdQuery);
             java.sql.PreparedStatement roomIdStmt = connection.prepareStatement(roomIdQuery);
             java.sql.PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
             java.sql.PreparedStatement reportStmt = connection.prepareStatement(reportSQL);
             java.sql.PreparedStatement updateRoomStatusStmt = connection.prepareStatement(updateRoomStatusSQL)) {

            // Retrieve user_id
            getUserIdStmt.setString(1, (String) checkOutDetails.get("accountName"));
            java.sql.ResultSet userResultSet = getUserIdStmt.executeQuery();

            if (userResultSet.next()) {
                int userId = userResultSet.getInt("user_id");

                // Retrieve room_id
                roomIdStmt.setString(1, (String) checkOutDetails.get("roomNumber"));
                java.sql.ResultSet roomResultSet = roomIdStmt.executeQuery();

                if (roomResultSet.next()) {
                    String roomId = roomResultSet.getString("room_id");

                    // Insert check-in details
                    insertStmt.setInt(1, userId);
                    insertStmt.setString(2, (String) checkOutDetails.get("customerName"));
                    insertStmt.setString(3, roomId);
                    insertStmt.setString(4, (String) checkOutDetails.get("noOfPerson"));
                    insertStmt.setString(5, (String) checkOutDetails.get("dateIn"));
                    insertStmt.setString(6, (String) checkOutDetails.get("dateOut"));
                    insertStmt.setString(7, (String) checkOutDetails.get("rate"));
                    insertStmt.setString(8, (String) checkOutDetails.get("totalChange"));
                    insertStmt.setString(9, (String) checkOutDetails.get("otherCharges"));
                    insertStmt.setString(10, (String) checkOutDetails.get("total"));
                    insertStmt.setString(11, (String) checkOutDetails.get("amountPaid"));
                    insertStmt.setString(12, (String) checkOutDetails.get("noOfDays"));


                    int rowsAffected = insertStmt.executeUpdate();

                    if (rowsAffected > 0) {
                        // Update room status
                        updateRoomStatusStmt.setString(1, roomId);
                        updateRoomStatusStmt.executeUpdate();

                        // Insert into report table
                        LocalTime currentTime = LocalTime.now();
                        LocalDate currentDate = LocalDate.now();
                        reportStmt.setString(1, "Check-out details added for customer name " + checkOutDetails.get("customerName"));
                        reportStmt.setString(2, currentDate.toString());
                        reportStmt.setString(3, currentTime.toString());

                        int reportRowsAffected = reportStmt.executeUpdate();

                        if (reportRowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Check-out details added successfully.");
                            AdminFrame adminFrame = new AdminFrame();
                            adminFrame.setVisible(true);
                            adminFrame.setResizable(false);
                            adminFrame.setLocationRelativeTo(null);
                            checkOutForm.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add report entry.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add check-in details.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Room not found. Please check the room number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "User not found. Please check the account name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
