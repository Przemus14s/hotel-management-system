package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String address;
    private int floors;
    private List<Room> rooms;
    private List<Staff> staff;

    public Hotel(String name, String address, int floors) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.rooms = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addStaffMember(Staff staffMember) {
        staff.add(staffMember);
    }

    public void listRooms() {
        System.out.println("Rooms in " + name + ":");
        for (Room room : rooms) {
            System.out.println("Room: " + room.getNumber() + " Type: " + room.getType() + " Status: " + room.getStatus());
        }
    }

    public void listStaff() {
        System.out.println("Staff in " + name + ":");
        for (Staff staffMember : staff) {
            System.out.println("Staff ID: " + staffMember.getStaffId() + " Name: " + staffMember.getName() + " Position: " + staffMember.getPosition());
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void addReservation(Reservation reservation) {
    }
}
