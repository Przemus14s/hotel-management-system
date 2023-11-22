package gornik.pl.klasy;

public class Room {
    private int number1;
    private String type;
    private String status;

    public Room(int number, String type, String status) {
        this.number1 = number;
        this.type = type;
        this.status = status;
    }

    public int getNumber() {
        return number1;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setOccupied(boolean b) {
    }

    public boolean isOccupied() {
        return false;
    }

    public RoomType getRoomType() {
        return null;
    }
}
