package gornik.pl.klasy;

public enum RoomType {
    SINGLE(new Price(100.0)),
    DOUBLE(new Price(200.0));
    private Price price;

    RoomType(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
