package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private Guest guest;
    private Room room;
    private int numberOfNights;
    private Parking parking;
    private List<RoomService> roomServices;

    public Reservation(Guest guest, Room room, int numberOfNights, Parking parking) {
        this.guest = guest;
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.parking = parking;
        this.roomServices = new ArrayList<>();
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public Parking getParking() {
        return parking;
    }

    public List<RoomService> getRoomServices() {
        return roomServices;
    }

    public void addRoomService(RoomService roomService) {
        roomServices.add(roomService);
    }

    public void addParking(Parking parking) {
        this.parking = parking;
    }

    public double calculateTotalPrice() {
        Price roomPrice = room.getRoomType().getPrice();
        double roomServicesPrice = calculateRoomServicesPrice();
        double parkingCost = parking.isIncluded() ? parking.getCost() : 0.0;
        return (roomPrice.getAmount() * numberOfNights) + roomServicesPrice + parkingCost;
    }

    private double calculateRoomServicesPrice() {
        double totalPrice = 0.0;
        for (RoomService roomService : roomServices) {
            totalPrice += roomService.getPrice().getAmount();
        }
        return totalPrice;
    }
}
