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
import milkbar.model.Category;

public class CategoryDAO {
    private static String sql="";
    public static List<Category> findAll(){
        sql="SELECT `category`.`name` FROM `milk_bar`.`category`;";
        List<Category> categorys=new LinkedList<>();
        try (Connection con = DBConnect.getCon();){
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String name=rs.getString(1);
                Category category=new Category(name);
                categorys.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorys;
    }
    public static Category findByName(String name){
        sql="SELECT `category`.`name` FROM `milk_bar`.`category` where name=?;";
        Category category=new Category();
        try (Connection con = DBConnect.getCon();){
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                name=rs.getString(1);
                category=new Category(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }
    public static boolean save(Category category){
        sql="INSERT INTO `milk_bar`.`category` (`name`) VALUES (?,?);";
        boolean isSaved=false;
        try (Connection con = DBConnect.getCon();){
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, category.getName());
            isSaved=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }
//    public static boolean update(Category category){
//        sql="UPDATE `milk_bar`.`category` SET `icon` = ? WHERE `name` = ?;";
//        boolean isSaved=false;
//        try (Connection con = DBConnect.getCon();){
//            PreparedStatement ps= con.prepareStatement(sql);
//            ps.setString(2, category.getName());
//            ps.setBytes(1, category.getIcon());
//            isSaved=!ps.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return isSaved;
//    }
}
