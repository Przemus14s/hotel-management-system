package gornik.pl;

import gornik.pl.klasy.*;

import java.util.List;
import java.util.Scanner;
public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel ABC");

        HotelMenager hotelManager = new HotelMenager(hotel);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj swoje imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj swój adres: ");
        String address = scanner.nextLine();

        Guest guest = new Guest(name, address);

        System.out.print("Wybierz rodzaj pokoju (1 - jednoosobowy, 2 - dwuosobowy): ");
        int roomChoice = scanner.nextInt();
        RoomType roomType = (roomChoice == 1) ? RoomType.SINGLE : RoomType.DOUBLE;

        System.out.print("Podaj liczbę nocy: ");
        int numberOfNights = scanner.nextInt();


        List<Room> availableRooms = hotel.getAvailableRooms();
        Room selectedRoom = null;
        for (Room room : availableRooms) {
            if (room.getRoomType() == roomType) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            Reservation reservation = new Reservation(guest, selectedRoom, numberOfNights);

            addAdditionalServices(reservation);

            hotelManager.makeReservation(reservation);

            double totalPrice = reservation.calculateTotalPrice();
            System.out.println("Całkowita cena rezerwacji: " + totalPrice + " zł");
        } else {
            System.out.println("Brak dostępnych pokoi tego rodzaju.");
        }

        scanner.close();
    }

    private static void addAdditionalServices(Reservation reservation) {
        Scanner scanner = new Scanner(System.in);
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

