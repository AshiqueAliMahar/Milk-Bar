package milkbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import milkbar.db.connection.DBConnect;
import milkbar.model.Table;

public class TableDAO {
    private static String sql="";
    public static List<Table> getAll() {
        sql="SELECT `table`.`table` FROM `milk_bar`.`table`;";
        List<Table> tables=new LinkedList<>();
        try(Connection con=DBConnect.getCon()) {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {                
                tables.add(new Table(rs.getString("table")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tables;
    }
    public static boolean save(String tableName){
        sql="INSERT INTO `milk_bar`.`table` (`table`)VALUES (?);";
        boolean isSaved=false;
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setString(1, tableName);
            isSaved=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }
    public static boolean isExist(String tableName){
        sql="SELECT `table`.`table` FROM `milk_bar`.`table` where `table`.`table`=?;";
        boolean isSaved=false;
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setString(1, tableName);
            isSaved=ps.executeQuery().next();
        } catch (SQLException ex) {
            Logger.getLogger(TableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }
    public static boolean delete(String tableName){
        sql="DELETE FROM `milk_bar`.`table` WHERE `table`=?;";
        boolean isSaved=false;
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setString(1, tableName);
            isSaved=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }
    
}
