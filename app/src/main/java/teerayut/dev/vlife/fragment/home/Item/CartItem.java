package teerayut.dev.vlife.fragment.home.Item;


public class CartItem {
    private ProductItem product;
    private int quantity;

    /*public CartItem(ProductItem product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }*/

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductItem getProduct() {
        return product;
    }

    public void setProduct(ProductItem product) {
        this.product = product;
    }

}
