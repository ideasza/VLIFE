package teerayut.dev.vlife.api.result;

import java.util.List;

/**
 * Created by teerayut.k on 9/6/2017.
 */

public class ProductItemResultGroup {

    private String STATUS;
    private List<ProductItemResult> PRODUCT;

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public List<ProductItemResult> getPRODUCT() {
        return PRODUCT;
    }

    public void setPRODUCT(List<ProductItemResult> PRODUCT) {
        this.PRODUCT = PRODUCT;
    }
}
