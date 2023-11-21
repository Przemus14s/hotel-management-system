package gornik.pl.klasy;

class Staff {
    private int staffId;
    private String name;
    private String position;

    public Staff(int staffId, String name, String position) {
        this.staffId = staffId;
        this.name = name;
        this.position = position;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
