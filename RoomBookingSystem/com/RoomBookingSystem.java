

import java.io.*;
import java.util.*;

public class RoomBookingSystem {
    private static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        loadRooms();
        showMenu();
    }

    private static void loadRooms() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\ikram\\tinx\\TinaxRoomBooking\\RoomBookingSystem\\com\\rooms.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] roomData = line.split(" ");
                int roomNum = Integer.parseInt(roomData[0]);
                String roomType = roomData[1];
                double roomPrice = Double.parseDouble(roomData[2]);
                boolean hasBalcony = Boolean.parseBoolean(roomData[3]);
                boolean hasLounge = Boolean.parseBoolean(roomData[4]);
                String reservationStatus = roomData[5];  // It will be "free" or "reserved"
                
                // Add the room with reservation status
                rooms.add(new Room(roomNum, roomType, roomPrice, hasBalcony, hasLounge, reservationStatus));
            }
            System.out.println("Rooms loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading rooms file.");
        }
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Afficher les chambres");
            System.out.println("2. Réserver une chambre");
            System.out.println("3. Annuler une réservation");
            System.out.println("4. Quitter");
            System.out.print("Veuillez choisir une option: ");
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
                    System.out.println("Option invalide.");
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
        System.out.print("Entrez le numéro de chambre à réserver: ");
        int roomNum = scanner.nextInt();
        
        Room room = findRoomByNumber(roomNum);
        if (room == null || room.getReservationStatus().equals("reserved")) {
            System.out.println("La chambre est déjà réservée ou introuvable.");
        } else {
            scanner.nextLine();  // Clear the newline character
            System.out.print("Entrez votre email: ");
            String email = scanner.nextLine();
            room.setReservationStatus("reserved");
            room.setEmail(email);
            System.out.println("Réservation effectuée avec succès.");
        }
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro de chambre à annuler: ");
        int roomNum = scanner.nextInt();
        
        Room room = findRoomByNumber(roomNum);
        if (room == null || room.getReservationStatus().equals("free")) {
            System.out.println("Aucune réservation trouvée pour cette chambre.");
        } else {
            room.setReservationStatus("free");
            room.setEmail(null);
            System.out.println("Réservation annulée avec succès.");
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
