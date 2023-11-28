package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private Guest guest;
    private Room room;
    private int numberOfNights;
    private List<RoomService> roomServices;

    public Reservation(Guest guest, Room room, int numberOfNights) {
        this.guest = guest;
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.roomServices = new ArrayList<>();
    }

    public Room getRoom() {
        return room;
    }

    public void addRoomService(RoomService roomService) {
        roomServices.add(roomService);
    }

    public double calculateTotalPrice() {
        Price roomPrice = room.getRoomType().getPrice();
        double roomServicesPrice = calculateRoomServicesPrice();
        return (roomPrice.getAmount() * numberOfNights) + roomServicesPrice;
    }

    private double calculateRoomServicesPrice() {
        double totalPrice = 0.0;
        for (RoomService roomService : roomServices) {
            totalPrice += roomService.getPrice().getAmount();
        }
        return totalPrice;
    }

    // Inne metody dostępowe (getters) i ustawiające (setters) w zależności od potrzeb
}

