package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private List<Order> orders;

    public RoomService() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Guest guest, String item, double price) {
        Order order = new Order(guest, item, price);
        orders.add(order);
        System.out.println("Zamówienie dla " + guest.getFirstName() + " " + guest.getLastName() +
                " przyjęte. Pozycja: " + item + ", Cena: " + price + " zł.");
    }

    public void displayOrderHistory() {
        System.out.println("Historia zamówień obsługi pokojowej:");
        for (Order order : orders) {
            System.out.println("Gość: " + order.getGuest().getFirstName() + " " + order.getGuest().getLastName() +
                    ", Zamówienie: " + order.getItem() +
                    ", Cena: " + order.getPrice() + " zł.");
        }
    }

    private static class Order {
        private Guest guest;
        private String item;
        private double price;

        public Order(Guest guest, String item, double price) {
            this.guest = guest;
            this.item = item;
            this.price = price;
        }

        public Guest getGuest() {
            return guest;
        }

        public String getItem() {
            return item;
        }

        public double getPrice() {
            return price;
        }
    }
}
