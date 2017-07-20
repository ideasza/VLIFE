package teerayut.dev.vlife.cart.payment.delivery.item;

/**
 * Created by teerayut.k on 7/13/2017.
 */

public class ThailandItem {

    private String id;
    private String name;

    public ThailandItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
