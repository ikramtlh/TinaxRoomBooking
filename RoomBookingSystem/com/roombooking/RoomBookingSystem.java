package roombooking;

import java.io.*;
import java.util.*;

public class RoomBookingSystem {
    private static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        loadRooms();
        showMenu();
    }

    private static void loadRooms() {
        try (Scanner scanner = new Scanner(new File("C:\\Users\\HP\\Desktop\\ikram\\tinx\\TinaxRoomBooking\\RoomBookingSystem\\com\\rooms.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] roomData = line.split(" ");
                if (roomData.length == 6) {
                    int roomNum = Integer.parseInt(roomData[0]);
                    String roomType = roomData[1];
                    double roomPrice = Double.parseDouble(roomData[2]);
                    boolean hasBalcony = Boolean.parseBoolean(roomData[3]);
                    boolean hasLounge = Boolean.parseBoolean(roomData[4]);
                    String reservationStatus = roomData[5];  
                    
                    rooms.add(new Room(roomNum, roomType, roomPrice, hasBalcony, hasLounge, reservationStatus));
                }
            }
            System.out.println("Rooms loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading rooms file.");
        }
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Show Rooms");
            System.out.println("2. Reserve a Room");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Quit");
            System.out.print("Please choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    showRooms();
                    break;
                case 2:
                    reserveRoom();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private static void showRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    private static void reserveRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the room number to reserve: ");
        int roomNum = scanner.nextInt();
        
        Room room = findRoomByNumber(roomNum);
        if (room == null || room.getReservationStatus().equals("reserved")) {
            System.out.println("The room is already reserved or not found.");
        } else {
            scanner.nextLine();  // Clear the newline character
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            room.setReservationStatus("reserved");
            room.setEmail(email);
            System.out.println("Reservation successfully made.");
        }
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the room number to cancel the reservation: ");
        int roomNum = scanner.nextInt();
        
        Room room = findRoomByNumber(roomNum);
        if (room == null || room.getReservationStatus().equals("free")) {
            System.out.println("No reservation found for this room.");
        } else {
            room.setReservationStatus("free");
            room.setEmail(null);
            System.out.println("Reservation successfully cancelled.");
        }
    }

    private static Room findRoomByNumber(int roomNum) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNum) {
                return room;
            }
        }
        return null;
    }
}
