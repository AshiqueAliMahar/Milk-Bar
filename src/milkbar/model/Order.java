package milkbar.model;

import java.sql.Timestamp;

public class Order {
    private long id;
    private String catName;
    private String subCatName;
    private int quantity;
    private int price;
    private Timestamp orderDate;
    private long orderCount;
    private Table table;
    private int gst,otherTax,discount;
    private OrderType orderType;
    private long shiftNo;

    public Order() {
    }

//    public Order(long id, String catName, String subCatName, int quantity, int price, Timestamp orderDate, long orderCount, Table table) {
//        this.id = id;
//        this.catName = catName;
//        this.subCatName = subCatName;
//        this.quantity = quantity;
//        this.price = price;
//        this.orderDate = orderDate;
//        this.orderCount = orderCount;
//        this.table = table;
//    }

    public Order(long id, String catName, String subCatName, int quantity, int price, Timestamp orderDate, long orderCount, Table table, int gst, int otherTax, int discount, OrderType orderType, long shiftNo) {
        this.id = id;
        this.catName = catName;
        this.subCatName = subCatName;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
        this.orderCount = orderCount;
        this.table = table;
        this.gst = gst;
        this.otherTax = otherTax;
        this.discount = discount;
        this.orderType = orderType;
        this.shiftNo = shiftNo;
    }

    public long getShiftNo() {
        return shiftNo;
    }

    public void setShiftNo(long shiftNo) {
        this.shiftNo = shiftNo;
    }
    
    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getOtherTax() {
        return otherTax;
    }

    public void setOtherTax(int otherTax) {
        this.otherTax = otherTax;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the catName
     */
    public String getCatName() {
        return catName;
    }

    /**
     * @param catName the catName to set
     */
    public void setCatName(String catName) {
        this.catName = catName;
    }

    /**
     * @return the subCatName
     */
    public String getSubCatName() {
        return subCatName;
    }

    /**
     * @param subCatName the subCatName to set
     */
    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the orderDate
     */
    public Timestamp getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the orderCount
     */
    public long getOrderCount() {
        return orderCount;
    }

    /**
     * @param orderCount the orderCount to set
     */
    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
    public void setOrderType(String orderType){
        if (orderType.equalsIgnoreCase(OrderType.DINE_IN.toString())) {
            this.orderType=OrderType.DINE_IN;
        }else if (orderType.equalsIgnoreCase(OrderType.TAKE_AWAY.toString())) {
            this.orderType=OrderType.TAKE_AWAY;
        }
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", catName=" + catName + ", subCatName=" + subCatName + ", quantity=" + quantity + ", price=" + price + ", orderDate=" + orderDate + ", orderCount=" + orderCount + ", table=" + table + ", gst=" + gst + ", otherTax=" + otherTax + ", discount=" + discount + ", orderType=" + orderType + '}';
    }
    
    
}
