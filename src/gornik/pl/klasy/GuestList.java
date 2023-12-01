package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

public class GuestList {
    private List<Guest> guests;

    public GuestList() {
        this.guests = new ArrayList<>();
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void removeGuest(Guest guest) {
        guests.remove(guest);
    }

    public Guest findGuestByName(String name) {
        for (Guest guest : guests) {
            if (guest.getName().equals(name)) {
                return guest;
            }
        }
        return null;
    }

    public Guest findGuestByNameAndSurname(String name, String surname) {
        for (Guest guest : guests) {
            if (guest.getName().equals(name) && guest.getSurname().equals(surname)) {
                return guest;
            }
        }
        return null;
    }
}
