package database_function;

import model.ReportModel;

import java.util.ArrayList;
import java.util.List;

public class ReportSQL {
    private static  volatile ReportSQL instance;

    public static ReportSQL getInstance() {
        if (instance == null) {
            synchronized (ReportSQL.class) {
                if (instance == null) {
                    instance = new ReportSQL();
                }
            }
        }
        return instance;
    }

    public List<ReportModel> getReports(){
        List<ReportModel> reportList = new ArrayList<>();
        String query = "SELECT * FROM report";
        try (java.sql.Connection connection = MYSQLiteConnection.getConnection();
             java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String reportId = resultSet.getString("report_id");
                String description = resultSet.getString("description");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                ReportModel reportModel = new ReportModel(reportId, description, date, time);
                reportList.add(reportModel);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        return reportList;
    }
}
