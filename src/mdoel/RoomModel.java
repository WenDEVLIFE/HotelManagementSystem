package mdoel;

public class RoomModel {

    String roomID;

    String roomStatus;

    public RoomModel(String roomID, String roomStatus) {
        this.roomID = roomID;
        this.roomStatus = roomStatus;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "RoomModel{" +
                "roomID='" + roomID + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
