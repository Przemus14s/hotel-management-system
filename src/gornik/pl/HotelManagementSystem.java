package gornik.pl;

import gornik.pl.klasy.*;

import java.util.List;
import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Zamek Lubelski");
        HotelMenager hotelManager = new HotelMenager(hotel);

        Scanner scanner = new Scanner(System.in);
        String name = enterName(scanner);
        String address = enterAddress(scanner);

        Guest guest = new Guest(name, address);

        System.out.print("Wybierz rodzaj pokoju (1 - jednoosobowy, 2 - dwuosobowy): ");
        int roomChoice = scanner.nextInt();
        RoomType roomType = (roomChoice == 1) ? RoomType.SINGLE : RoomType.DOUBLE;

        List<Room> availableRooms = hotel.getAvailableRooms();
        Room selectedRoom = findAvailableRoom(availableRooms, roomType);

        if (selectedRoom != null) {
            System.out.print("Podaj liczbę nocy: ");
            int numberOfNights = scanner.nextInt();

            Parking parking = new Parking(false);
            parking.askForParking(scanner);

            Reservation reservation = new Reservation(guest, selectedRoom, numberOfNights, parking);

            addAdditionalServices(reservation, scanner);

            hotelManager.makeReservation(reservation);

            double totalPrice = reservation.calculateTotalPrice();
            System.out.println("Całkowita cena rezerwacji: " + totalPrice + " zł");
        } else {
            System.out.println("Brak dostępnych pokoi tego rodzaju.");
        }

        scanner.close();
    }

    private static String enterName(Scanner scanner) {
        System.out.print("Podaj swoje imię: ");
        while (!scanner.hasNext("[A-Za-z]+")) {
            System.out.println("Nieprawidłowe imię. Spróbuj ponownie.");
            System.out.print("Podaj swoje imię: ");
            scanner.next();
        }
        return scanner.next();
    }

    private static String enterAddress(Scanner scanner) {
        System.out.print("Podaj swój adres: ");
        while (!scanner.hasNext("[A-Za-z0-9\\s]+")) {
            System.out.println("Nieprawidłowy adres. Spróbuj ponownie.");
            System.out.print("Podaj swój adres: ");
            scanner.next();
        }
        return scanner.next();
    }

    private static Room findAvailableRoom(List<Room> availableRooms, RoomType roomType) {
        for (Room room : availableRooms) {
            if (room.getRoomType() == roomType && !room.isReserved()) {
                return room;
            }
        }
        return null;
    }

    private static void addAdditionalServices(Reservation reservation, Scanner scanner) {
        System.out.println("Dostępne dodatkowe usługi:");
        System.out.println("1. Jedzenie (200 zł za noc)");
        System.out.println("2. Masaż (200 zł za noc)");

        boolean continueAddingServices = true;
        while (continueAddingServices) {
            System.out.print("Wybierz dodatkową usługę (0 aby zakończyć): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservation.addRoomService(new RoomService("Jedzenie"));
                    break;
                case 2:
                    reservation.addRoomService(new RoomService("Masaż"));
                    break;
                case 0:
                    continueAddingServices = false;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }
}
