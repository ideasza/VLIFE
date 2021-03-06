package teerayut.dev.vlife.profile.order_history.item;

import com.android.tonyvu.sc.model.Saleable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import teerayut.dev.vlife.home.Item.ProductItem;

/**
 * Created by teerayut.k on 7/16/2017.
 */

public class OrderHistoryItem{

    private String orderNumber;
    private String orderType;
    private String orderDate;
    private String memberCode;
    private String Price;
    private String Pv;

    private List<ProductItem> productItems;

    public OrderHistoryItem() {

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPv() {
        return Pv;
    }

    public void setPv(String pv) {
        Pv = pv;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }
}
