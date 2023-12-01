package gornik.pl.klasy;

import java.util.Scanner;

import static gornik.pl.klasy.ParkingLot.CAPACITY;

public class Parking {
    private boolean included;
    private double cost;

    public Parking() {
        this.included = false;
        this.cost = 0.0;
    }

    public void askForParking(Scanner scanner) {
        System.out.println("Ilość dostępnych miejsć parkingowych: " + CAPACITY);
        System.out.print("Czy chcesz dokupić miejsce parkingowe? (1 - Tak, 0 - Nie): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            this.included = true;
            this.cost = 50.0;
        }
    }

    public boolean isIncluded() {
        return included;
    }

    public double getCost() {
        return cost;
    }
}
