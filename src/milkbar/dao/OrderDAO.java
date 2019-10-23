package milkbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import milkbar.db.connection.DBConnect;
import milkbar.model.Order;
import milkbar.model.Table;

public class OrderDAO {

    private static String sql = "";

    public static boolean save(final Order order) {
        boolean isSaved = false;
        sql = "INSERT INTO `milk_bar`.`orders` (`cat_name`,`sub_cat_name`,`qunatity`,`price`,`order_date`,order_count,`table`,`orders`.`gst`,`orders`.`other_tax`,`orders`.`discount`,order_type,shift) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = DBConnect.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, order.getCatName());
            ps.setString(2, order.getSubCatName());
            ps.setLong(3, order.getQuantity());
            ps.setLong(4, order.getPrice());
            ps.setTimestamp(5, order.getOrderDate());
            ps.setLong(6, order.getOrderCount());
            ps.setString(7, order.getTable().getTableName());
            ps.setInt(8, order.getGst());
            ps.setInt(9, order.getOtherTax());
            ps.setInt(10, order.getDiscount());
            ps.setString(11, order.getOrderType().toString());
            ps.setLong(12, order.getShiftNo());
            isSaved = !ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }

//    public static boolean updateByOrderCount(Order order){
//        boolean isSaved = false;
//        sql = "INSERT INTO `milk_bar`.`orders` (`cat_name`,`sub_cat_name`,`qunatity`,`price`,`order_date`,order_count,`table`) VALUES (?,?,?,?,?,?,?);";
//        Connection con = DBConnect.getCon();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, order.getCatName());
//            ps.setString(2, order.getSubCatName());
//            ps.setLong(3, order.getQuantity());
//            ps.setLong(4, order.getPrice());
//            ps.setTimestamp(5, order.getOrderDate());
//            ps.setLong(6, order.getOrderCount());
//            ps.setString(7, order.getTable().getTableName());
//            isSaved = !ps.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return isSaved;
//    }
    public static long maxOrderCount() {
        sql = "select ifnull(max(order_count),0) from orders;";
        Connection con = DBConnect.getCon();
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static long maxShiftCount() {
        sql = "select ifnull(max(shift),0) from orders;";
        Connection con = DBConnect.getCon();
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static List<Order> getOrders(Timestamp from, Timestamp to) {
        List<Order> orders = new LinkedList<>();
        sql = "SELECT `orders`.`id`,\n"
                + "    `orders`.`cat_name`,\n"
                + "    `orders`.`sub_cat_name`,\n"
                + "    `orders`.`qunatity`,\n"
                + "    `orders`.`price`,\n"
                + "    `orders`.`order_date`,\n"
                + "    `orders`.`order_count`,`orders`.`table`,\n"
                + "    `orders`.`gst`,\n"
                + "    `orders`.`other_tax`,\n"
                + "    `orders`.`discount`,"
                + "     order_type,"
                + "     shift "
                + "FROM `milk_bar`.`orders` where order_date between ? and ?;";
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setTimestamp(1, from);
            ps.setTimestamp(2, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getLong("id"), rs.getString("cat_name"), rs.getString("sub_cat_name"), rs.getInt("qunatity"), rs.getInt("price"), rs.getTimestamp("order_date"), rs.getInt("order_count"), new Table(rs.getString("table")),rs.getInt("gst"),rs.getInt("other_tax"),rs.getInt("discount"),null,rs.getLong("shift"));
                order.setOrderType(rs.getString("order_type"));
                
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orders;
    }

    public static List<Order> getOrders(Long orderCount) {
        List<Order> orders = new LinkedList<>();
        sql = "SELECT `orders`.`id`,\n"
                + "    `orders`.`cat_name`,\n"
                + "    `orders`.`sub_cat_name`,\n"
                + "    `orders`.`qunatity`,\n"
                + "    `orders`.`price`,\n"
                + "    `orders`.`order_date`,\n"
                + "    `orders`.`order_count`,`orders`.`table`,`orders`.`gst`,\n"
                + "    `orders`.`other_tax`,\n"
                + "    `orders`.`discount` ,\n"
                + "     order_type,"
                + "     shift "
                + "FROM `milk_bar`.`orders` where order_count=?;";
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setLong(1, orderCount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getLong("id"), rs.getString("cat_name"), rs.getString("sub_cat_name"), rs.getInt("qunatity"), rs.getInt("price"), rs.getTimestamp("order_date"), rs.getInt("order_count"), new Table(rs.getString("table")),rs.getInt("gst"),rs.getInt("other_tax"),rs.getInt("discount"),null,rs.getLong("shift"));
                order.setOrderType(rs.getString("order_type"));
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orders;
    }

    public static List<Order> getGroupedOrders(Timestamp from, Timestamp to) {
        List<Order> orders = new LinkedList<>();
        sql = "SELECT \n"
                + "    `orders`.`order_date`,\n"
                + "    `orders`.`order_count`,\n"
                + "    `orders`.`table`,sum(qunatity*price),gst,other_tax,discount,order_type\n"
                + "FROM `milk_bar`.`orders` where order_date between ? and ?  group by order_count;";
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setTimestamp(1, from);
            ps.setTimestamp(2, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(0, null, null, 0, rs.getInt(4), rs.getTimestamp("order_date"), rs.getInt("order_count"), new Table(rs.getString("table")),rs.getInt("gst"),rs.getInt("other_tax"),rs.getInt("discount"),null,0);
                order.setOrderType(rs.getString("order_type"));
                
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orders;
    }

    public static boolean deleteByOrderCount(long orderCount) {
        boolean isDel = false;
        sql = "delete FROM milk_bar.orders where order_count=?;";
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setLong(1, orderCount);
            isDel = !ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isDel;
    }
}