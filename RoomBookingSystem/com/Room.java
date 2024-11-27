

public class Room {
    private int roomNum;
    private String roomType;
    private double roomPrice;
    private boolean hasBalcony;
    private boolean hasLounge;
    private String reservationStatus;  // "free" or "reserved"
    private String email;

    public Room(int roomNum, String roomType, double roomPrice, boolean hasBalcony, boolean hasLounge, String reservationStatus) {
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.hasBalcony = hasBalcony;
        this.hasLounge = hasLounge;
        this.reservationStatus = reservationStatus;
    }

    public int getRoomNumber() {
        return roomNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public boolean hasLounge() {
        return hasLounge;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNum + ", Type: " + roomType + ", Price: " + roomPrice
                + ", Balcony: " + (hasBalcony ? "Yes" : "No") + ", Lounge: " + (hasLounge ? "Yes" : "No")
                + ", Reservation Status: " + reservationStatus + (email != null ? ", Reserved by: " + email : "");
    }
}
