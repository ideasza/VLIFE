package teerayut.dev.vlife.home.Item;

import com.android.tonyvu.sc.model.Saleable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by teerayut.k on 7/10/2017.
 */

public class ProductItem implements Saleable, Serializable {
    private static final long serialVersionUID = -4073256626483275668L;

    private String id;
    private String name;
    private String pv;
    private BigDecimal price;
    private String image;
    private boolean isAdded = false;

    public ProductItem() {
        super();
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof ProductItem)) return false;

        return (this.id == ((ProductItem) o).getId());
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = hash * prime +  (id == null ? 0 : id.hashCode());;
        hash = hash * prime + (name == null ? 0 : name.hashCode());
        hash = hash * prime + (pv == null ? 0 : pv.hashCode());
        hash = hash * prime + (price == null ? 0 : price.hashCode());
        hash = hash * prime + (image == null ? 0 : image.hashCode());

        return hash;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
