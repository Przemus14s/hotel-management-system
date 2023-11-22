package gornik.pl;

import gornik.pl.klasy.*;

import java.util.Scanner;

public class HotelManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hotel hotel = new Hotel("Zamek", "Tarnobrzeg", 3);
        HotelManager hotelManager = new HotelManager(hotel);

        System.out.print("Podaj imię: ");
        String firstName = scanner.nextLine();

        System.out.print("Podaj nazwisko: ");
        String lastName = scanner.nextLine();

        System.out.print("Podaj numer kontaktowy: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Podaj adres email: ");
        String email = scanner.nextLine();

        Guest guest = new Guest(firstName, lastName, contactNumber, email);

        System.out.println("Dostępne typy pokoi:");
        for (RoomType roomType : RoomType.values()) {
            System.out.println(roomType.ordinal() + 1 + ". " + roomType.getDisplayName());
        }

        System.out.print("Wybierz numer typu pokoju: ");
        int roomTypeChoice = scanner.nextInt();

        RoomType[] roomTypes = RoomType.values();
        if (roomTypeChoice >= 1 && roomTypeChoice <= roomTypes.length) {
            RoomType selectedRoomType = roomTypes[roomTypeChoice - 1];
            Room room = hotelManager.findAvailableRoom(selectedRoomType);

            if (room != null) {
                System.out.println("Pokój dostępny! Tworzenie rezerwacji...");

                System.out.print("Podaj datę zameldowania (np. DD/MM/YYYY): ");
                String checkInDate = scanner.next();

                System.out.print("Podaj datę wymeldowania (np. DD/MM/YYYY): ");
                String checkOutDate = scanner.next();

                Reservation reservation = new Reservation(guest, room, checkInDate, checkOutDate);
                hotelManager.makeReservation(reservation);

                System.out.println("Rezerwacja zakończona pomyślnie. Dziękujemy!");
            } else {
                System.out.println("Przykro nam, ale wybrany typ pokoju jest niedostępny.");
            }
        } else {
            System.out.println("Nieprawidłowy numer typu pokoju. Spróbuj ponownie.");
        }
    }
}

