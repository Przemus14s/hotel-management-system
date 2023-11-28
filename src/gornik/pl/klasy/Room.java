package gornik.pl.klasy;

public class Room {
    private int roomNumber;
    private RoomType roomType;
    private boolean reserved;

    public Room(int roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.reserved = false;
    }
    public RoomType getRoomType() {
        return roomType;
    }
    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        this.reserved = true;
    }

    public void unreserve() {
        this.reserved = false;
    }

}
