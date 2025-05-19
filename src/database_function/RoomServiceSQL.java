package database_function;

import mdoel.RoomModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceSQL {

    private static volatile RoomServiceSQL instance;

    public static RoomServiceSQL getInstance() {
        if (instance == null) {
            synchronized (RoomServiceSQL.class) {
                if (instance == null) {
                    instance = new RoomServiceSQL();
                }
            }
        }
        return instance;
    }

    public void InsertRoom(String roomID) {
        String query = "INSERT INTO room (room_id, room_status) VALUES (?, ?)";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roomID);
            statement.setString(2, "Available");
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Room inserted successfully.");
                JOptionPane.showMessageDialog(null, "Room inserted successfully.");
            } else {
                System.out.println("Failed to insert room.");
                JOptionPane.showMessageDialog(null, "Failed to insert room.");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RoomModel> getAllRooms() {
        List<RoomModel> roomList = new ArrayList<>();
        String query = "SELECT * FROM room";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query);
             java.sql.ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String roomID = resultSet.getString("room_id");
                String roomStatus = resultSet.getString("room_status");
                RoomModel roomModel = new RoomModel(roomID, roomStatus);
                roomList.add(roomModel);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        
        return roomList;
    }

    public void DeleteRoom(String roomID) {
        String query = "DELETE FROM room WHERE room_id = ?";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roomID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Room deleted successfully.");
                JOptionPane.showMessageDialog(null, "Room deleted successfully.");
            } else {
                System.out.println("Failed to delete room.");
                JOptionPane.showMessageDialog(null, "Failed to delete room.");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
