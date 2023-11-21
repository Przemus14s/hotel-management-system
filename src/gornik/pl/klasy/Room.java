package gornik.pl.klasy;

class Room {
    private int number;
    private String type;
    private String status;

    public Room(int number, String type, String status) {
        this.number = number;
        this.type = type;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
}
