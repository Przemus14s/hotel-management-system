package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class HotelMenager {
    private Hotel hotel;
    private List<Reservation> reservations;

    public HotelMenager(Hotel hotel) {
        this.hotel = hotel;
        this.reservations = new ArrayList<>();
    }

    public void makeReservation(Reservation reservation) {
        Room room = reservation.getRoom();

        // Sprawdź, czy pokój jest dostępny
        if (!room.isReserved()) {
            // Oznacz pokój jako zarezerwowany
            room.reserve();

            // Dodaj rezerwację do listy rezerwacji
            reservations.add(reservation);

            System.out.println("Rezerwacja zakończona pomyślnie.");

            // Oblicz i wypisz cenę rezerwacji
            double totalPrice = reservation.calculateTotalPrice();
            System.out.println("Cena rezerwacji: " + totalPrice + " zł");
        } else {
            System.out.println("Wybrany pokój jest już zarezerwowany.");
        }
    }

    // Inne metody zarządzające rezerwacjami
    // np. public List<Reservation> getReservations() {...}
    // oraz inne metody w zależności od potrzeb
}