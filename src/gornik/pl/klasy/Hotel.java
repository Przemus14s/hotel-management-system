package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.rooms.add(new Room(1, RoomType.SINGLE));
        this.rooms.add(new Room(2, RoomType.DOUBLE));


    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isReserved()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

}
