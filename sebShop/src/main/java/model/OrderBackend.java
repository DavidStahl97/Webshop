package model;

public class OrderBackend extends Order {

    private static final long serialVersionUID = 5041529395169903033L;
    private int OrderNo;

    public int getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(int orderNo) {
        OrderNo = orderNo;
    }
}
