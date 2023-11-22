package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private Hotel hotel;

    public HotelManager(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room findAvailableRoom(RoomType roomType) {
        List<Room> availableRooms = new ArrayList<>();

        for (Room room : hotel.getRooms()) {
            if (room.getRoomType() == roomType && !room.isOccupied()) {
                availableRooms.add(room);
            }
        }

        return availableRooms.isEmpty() ? null : availableRooms.get(0);
    }

    public void makeReservation(Reservation reservation) {
        hotel.addReservation(reservation);

        reservation.getRoom().setOccupied(true);
    }

}
