package roombooking;

public class Room {
    private int roomNumber;
    private String roomType;
    private double roomPrice;
    private boolean hasBalcony;
    private boolean hasLounge;
    private String reservationStatus;  
    private String email; 

    public Room(int roomNumber, String roomType, double roomPrice, boolean hasBalcony, boolean hasLounge, String reservationStatus) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.hasBalcony = hasBalcony;
        this.hasLounge = hasLounge;
        this.reservationStatus = reservationStatus;
    }

    // Getter and Setter methods
    public int getRoomNumber() {
        return roomNumber;
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
        return String.format("Room Number: %d, Type: %s, Price: £%.2f, Balcony: %b, Lounge: %b, Reservation Status: %s, Email: %s",
                roomNumber, roomType, roomPrice, hasBalcony, hasLounge, reservationStatus, email);
    }
}
