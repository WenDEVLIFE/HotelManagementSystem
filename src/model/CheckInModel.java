package model;

public class CheckInModel {

    String id;

    String customerName;

    String roomNumber;

    String NoOfPersons;

    String DateIn;

    String DateOut;

    String NoOfNights;

    String advancePayment;

    String balancePayment;


    public CheckInModel (String id, String customerName, String roomNumber, String noOfPersons, String dateIn, String dateOut, String noOfNights, String advancePayment, String balancePayment) {
        this.id = id;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.NoOfPersons = noOfPersons;
        this.DateIn = dateIn;
        this.DateOut = dateOut;
        this.NoOfNights = noOfNights;
        this.advancePayment = advancePayment;
        this.balancePayment = balancePayment;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNoOfPersons() {
        return NoOfPersons;
    }


    public void setNoOfPersons(String noOfPersons) {
        NoOfPersons = noOfPersons;
    }

    public String getDateIn() {
        return DateIn;
    }

    public void setDateIn(String dateIn) {
        DateIn = dateIn;
    }

    public String getDateOut() {
        return DateOut;
    }

    public void setDateOut(String dateOut) {
        DateOut = dateOut;
    }

    public String getNoOfNights() {
        return NoOfNights;
    }

    public void setNoOfNights(String noOfNights) {
        NoOfNights = noOfNights;
    }

    public String getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(String advancePayment) {
        this.advancePayment = advancePayment;
    }

    public String getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(String balancePayment) {
        this.balancePayment = balancePayment;
    }
    @Override
    public String toString() {
        return "CheckInModel{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", NoOfPersons='" + NoOfPersons + '\'' +
                ", DateIn='" + DateIn + '\'' +
                ", DateOut='" + DateOut + '\'' +
                ", NoOfNights='" + NoOfNights + '\'' +
                ", advancePayment='" + advancePayment + '\'' +
                ", balancePayment='" + balancePayment + '\'' +
                '}';
    }



}

