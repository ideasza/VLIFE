package teerayut.dev.vlife.profile.hold.item;

import java.util.List;

import teerayut.dev.vlife.home.Item.ProductItem;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public class HoldItem {

    private String orderNumber;
    private String orderAmount;
    private String orderType;
    private String orderDate;
    private String memberCode;
    private String Price;
    private String Pv;

    private List<ProductItem> productItems;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
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
