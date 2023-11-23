package gornik.pl.klasy;

class Price extends Room {
    private double pricePerNight;

    public Price(int roomNumber, RoomType roomType, double pricePerNight) {
        super(roomNumber, roomType);
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double calculateTotalPrice(int numberOfNights) {
        return pricePerNight * numberOfNights;
    }

    @Override
    public String toString() {
        return "Price{" +
                ", roomType=" + getRoomType() +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}
