package model;

public class ReportModel {

    String reportId;

    String description;

    String date;

    String time;


    public ReportModel(String reportId, String description, String date, String time) {
        this.reportId = reportId;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ReportModel{" +
                "reportId='" + reportId + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
