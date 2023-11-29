package gornik.pl.klasy;

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


        if (!room.isReserved()) {

            room.reserve();


            reservations.add(reservation);

            System.out.println("Rezerwacja zakończona pomyślnie.");


            double totalPrice = reservation.calculateTotalPrice();
            System.out.println("Cena rezerwacji: " + totalPrice + " zł");
        } else {
            System.out.println("Wybrany pokój jest już zarezerwowany.");
        }
    }


}
