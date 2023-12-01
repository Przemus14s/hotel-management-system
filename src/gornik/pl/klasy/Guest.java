package gornik.pl.klasy;

import java.util.Scanner;

public class Guest {
    private String name;
    private String surname;
    private String address;
    private Reservation reservation;

    public Guest(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void enterName(Scanner scanner) {
        System.out.print("Podaj imię: ");
        this.name = scanner.next();
    }

    public void enterSurname(Scanner scanner) {
        System.out.print("Podaj nazwisko: ");
        this.surname = scanner.next();
    }

    public void enterAddress(Scanner scanner) {
        System.out.print("Podaj adres: ");
        this.address = scanner.next();
    }

    public String getAddress() {
        return address;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean isValid() {
        return isValidName(this.name) && isValidSurname(this.surname) && isValidAddress(this.address);
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]+");
    }

    private boolean isValidSurname(String surname) {
        return surname.matches("[a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]+");
    }

    private boolean isValidAddress(String address) {
        return address.matches("[a-zA-Z0-9ęóąśłżźćńĘÓĄŚŁŻŹĆŃ ]+");
    }
}
