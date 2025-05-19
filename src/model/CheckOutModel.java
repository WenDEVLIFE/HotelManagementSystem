package model;

public class CheckOutModel {

    private String id;
    private String guestName;
    private String roomNumber;
    private String noOfPersons;
    private String dateIn;
    private String dateOut;
    private String rate;
    private String totalChange;
    private String otherCharges;
    private String total;
    private String amount;
    private String noOfDays;

    public CheckOutModel(String id, String guestName, String roomNumber, String noOfPersons, String dateIn,
                         String dateOut ,String rate, String totalChange,
                         String otherCharges, String total, String amount, String noOfDays) {
        this.id = id;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.noOfPersons = noOfPersons;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.rate = rate;
        this.totalChange = totalChange;
        this.otherCharges = otherCharges;
        this.total = total;
        this.amount = amount;
        this.noOfDays = noOfDays;
    }

    public String getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getNoOfPersons() {
        return noOfPersons;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public String getRate() {
        return rate;
    }

    public String getTotalChange() {
        return totalChange;
    }

    public String getOtherCharges() {
        return otherCharges;
    }

    public String getTotal() {
        return total;
    }

    public String getAmount() {
        return amount;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    @Override
    public String toString() {
        return "CheckOutModel{" +
                "id='" + id + '\'' +
                ", guestName='" + guestName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", noOfPersons='" + noOfPersons + '\'' +
                ", dateIn='" + dateIn + '\'' +
                ", dateOut='" + dateOut + '\'' +
                ", rate='" + rate + '\'' +
                ", totalChange='" + totalChange + '\'' +
                ", otherCharges='" + otherCharges + '\'' +
                ", total='" + total + '\'' +
                ", amount='" + amount + '\'' +
                ", noOfDays='" + noOfDays + '\'' +
                '}';
    }
}