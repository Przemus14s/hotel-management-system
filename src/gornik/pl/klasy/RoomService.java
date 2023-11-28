package gornik.pl.klasy;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    public static final Price DEFAULT_PRICE = new Price(200.0);

    private String serviceName;
    private Price price;

    public RoomService(String serviceName) {
        this.serviceName = serviceName;
        this.price = DEFAULT_PRICE;
    }

    public Price getPrice() {
        return price;
    }
}
