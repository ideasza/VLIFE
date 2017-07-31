package teerayut.dev.vlife.profile.point.point_history.item;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public class PointItem {

    private String orderNumber;
    private String orderDate;
    private String pointType;
    private String point;

    public PointItem() {

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
