package gornik.pl;

import gornik.pl.klasy.*;

import java.util.List;
import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Zamek Lubelski");
        HotelManager hotelManager = new HotelManager(hotel);
        GuestList guestList = createGuestListWith20Guests();

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("Witaj w programie Zamku Lubelskiego");

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Dodaj nowego gościa");
            System.out.println("2. Zarezerwuj pokój");
            System.out.println("3. Modyfikuj lub usuń gościa");
            System.out.println("4. Wyświetl listę gości");
            System.out.println("0. Zakończ program");
            System.out.println("---------------------------------");

            System.out.print("Wybierz opcję: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewGuest(scanner, guestList);
                    break;
                case 2:
                    makeReservation(scanner, hotel, hotelManager, guestList);
                    break;
                case 3:
                    modifyOrRemoveGuest(scanner, guestList);
                    break;
                case 4:
                    displayGuestList(guestList);
                    break;
                case 0:
                    System.out.println("Program zakończony.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }
    }

    private static GuestList createGuestListWith20Guests() {
        GuestList guestList = new GuestList();
        guestList.addGuest(new Guest("Anna", "Kowalska", "Gdańsk"));
        guestList.addGuest(new Guest("Helmunda", "Nowak", "Rzeszów"));
        guestList.addGuest(new Guest("Katarzyna", "Japko", "Trzcina"));
        guestList.addGuest(new Guest("Piotr","Bogota", "Trzcina"));
        guestList.addGuest(new Guest("Magdalena", "Sroka","Zakopane"));
        guestList.addGuest(new Guest("Grzegorz", "Pęk","Warszawa"));
        guestList.addGuest(new Guest("Agnieszka","Nowaczek", "Kraków"));
        guestList.addGuest(new Guest("Krzysztof", "Rozpara","Gniezno"));
        guestList.addGuest(new Guest("Joanna", "Koza","Poznań"));
        guestList.addGuest(new Guest("Marek", "Ziemiak","Lublin"));
        guestList.addGuest(new Guest("Ewa", "Enimem","Skrzypaczowice"));
        guestList.addGuest(new Guest("Tomasz", "Rzepka", "Gorzyce"));
        guestList.addGuest(new Guest("Karolina", "Arbuz", "Koprzywnica"));
        guestList.addGuest(new Guest("Artur", "Por", "Tarnobrzeg"));
        guestList.addGuest(new Guest("Monika", "Nowak", "Zator"));
        guestList.addGuest(new Guest("Rafał", "Kowalski","Krosno"));
        guestList.addGuest(new Guest("Beata", "Jelly","Izdebki"));
        guestList.addGuest(new Guest("Wojciech", "Herbata", "Sokołow"));
        guestList.addGuest(new Guest("Mariola", "Słowiański", "Stale"));
        guestList.addGuest(new Guest("Dariusz", "Gońciarz", "Kacperkowo"));

        return guestList;
    }

    private static void addNewGuest(Scanner scanner, GuestList guestList) {
        Guest newGuest = new Guest("", "", "");
        newGuest.enterName(scanner);
        newGuest.enterSurname(scanner);
        newGuest.enterAddress(scanner);

        if (newGuest.isValid()) {
            guestList.addGuest(newGuest);
            System.out.println("Nowy gość dodany do listy.");
        } else {
            System.out.println("Błąd: Nieprawidłowe dane gościa. Nie dodano nowego gościa.");

        }
    }

    private static void makeReservation(Scanner scanner, Hotel hotel, HotelManager hotelManager, GuestList guestList) {
        System.out.print("Podaj imię gościa: ");
        String guestName = scanner.next();
        Guest guest = guestList.findGuestByName(guestName);

        if (guest != null) {
            System.out.print("Wybierz rodzaj pokoju (1 - jednoosobowy, 2 - dwuosobowy): ");
            int roomChoice = scanner.nextInt();
            RoomType roomType = (roomChoice == 1) ? RoomType.SINGLE : RoomType.DOUBLE;

            List<Room> availableRooms = hotel.getAvailableRooms();
            Room selectedRoom = findAvailableRoom(availableRooms, roomType);

            if (selectedRoom != null) {
                System.out.print("Podaj liczbę nocy: ");
                int numberOfNights = scanner.nextInt();

                Parking parking = new Parking();
                parking.askForParking(scanner);

                Reservation reservation = new Reservation(guest, selectedRoom, numberOfNights, parking);

                addAdditionalServices(reservation, scanner);

                hotelManager.makeReservation(reservation);

                guest.setReservation(reservation);

                displayGuestDetails(guest, reservation);
            } else {
                System.out.println("Brak dostępnych pokoi tego rodzaju.");
            }
        } else {
            System.out.println("Nie znaleziono gościa o podanym imieniu.");
        }
    }

    private static void modifyOrRemoveGuest(Scanner scanner, GuestList guestList) {
        System.out.println("---------------------------------");
        System.out.println("Menu modyfikacji/usuwania/dodawania gościa:");
        System.out.println("1. Znajdź gościa do modyfikacji");
        System.out.println("2. Usuń gościa");
        System.out.println("3. Dodaj nowego gościa");
        System.out.println("0. Powrót do głównego menu");
        System.out.println("---------------------------------");

        System.out.print("Wybierz opcję: ");
        int modifyOrRemoveChoice = scanner.nextInt();

        switch (modifyOrRemoveChoice) {
            case 1:
                modifyGuest(scanner, guestList);
                break;
            case 2:
                removeGuest(scanner, guestList);
                break;
            case 3:
                addNewGuest(scanner, guestList);
                break;
            case 0:
                break;
            default:
                System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
        }
    }

    private static void modifyGuest(Scanner scanner, GuestList guestList) {
        System.out.print("Podaj imię gościa do modyfikacji: ");
        String guestName = scanner.next();
        Guest existingGuest = guestList.findGuestByName(guestName);

        if (existingGuest != null) {
            System.out.println("[Nowe]");
            existingGuest.enterName(scanner);
            existingGuest.enterSurname(scanner);
            existingGuest.enterAddress(scanner);

            if (existingGuest.isValid()) {
                System.out.println("Dane gościa zostały zaktualizowane.");
            } else {
                System.out.println("Nieprawidłowe dane gościa. Dane gościa nie zostały zaktualizowane.");
            }
        } else {
            System.out.println("Nie znaleziono gościa o podanym imieniu.");
        }
    }

    private static void removeGuest(Scanner scanner, GuestList guestList) {
        System.out.print("Podaj imię gościa do usunięcia: ");
        String guestName = scanner.next();
        Guest guestToRemove = guestList.findGuestByName(guestName);

        if (guestToRemove != null) {
            guestList.removeGuest(guestToRemove);
            System.out.println("Gość został usunięty z listy.");
        } else {
            System.out.println("Nie znaleziono gościa o podanym imieniu.");
        }
    }

    private static void displayGuestList(GuestList guestList) {
        System.out.println("Lista gości:");
        for (Guest guest : guestList.getGuests()) {
            System.out.println("Imię: " + guest.getName() + " Nazwisko: " + guest.getSurname() + ", Adres: " + guest.getAddress());

            Reservation guestReservation = guest.getReservation();
            if (guestReservation != null) {
                displayGuestDetails(guest, guestReservation);
            } else {
                System.out.println("Brak dostępnej rezerwacji.");
            }

            System.out.println();
        }
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
        System.out.println("1. Jedzenie (Cena 150 zł)");
        System.out.println("2. Masaż (Cena 150 zł)");
        System.out.println("3. Przechowalnia bagażu (Cena 150 zł)");
        System.out.println("4. Barek (Cena 150 zł)");

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
                case 3:
                    reservation.addRoomService(new RoomService("Przechowalnia bagażu"));
                    break;
                case 4:
                    reservation.addRoomService(new RoomService("Barek"));
                    break;
                case 0:
                    continueAddingServices = false;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void displayGuestDetails(Guest guest, Reservation reservation) {
        System.out.println("Pokój: " + reservation.getRoom().getRoomNumber());
        System.out.println("Rodzaj pokoju: " + reservation.getRoom().getRoomType());
        System.out.println("Ilość nocy: " + reservation.getNumberOfNights());
        System.out.println("Cena rezerwacji: " + reservation.calculateTotalPrice() + " zł");

        List<RoomService> roomServices = reservation.getRoomServices();
        if (!roomServices.isEmpty()) {
            System.out.println("Dodatkowe usługi:");
            for (RoomService service : roomServices) {
                System.out.println("- " + service.getServiceName());
            }
        } else {
            System.out.println("Brak dodatkowych usług.");
        }

        System.out.println();
    }
}
