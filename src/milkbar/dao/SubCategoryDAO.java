/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import milkbar.model.SubCategory;

/**
 *
 * @author ali.ashique
 */
public class SubCategoryDAO {

    private static String sql = "";

    public static List<SubCategory> findByCatName(String catName) {
        sql = "SELECT `sub_category`.`name`,\n"
                + "    `sub_category`.`price`,\n"
                + "    `sub_category`.`cat_name`\n"
                + "FROM `milk_bar`.`sub_category` where cat_name=?;";
        List<SubCategory> subCategorys=new LinkedList<>();
        
        try (Connection con = DBConnect.getCon();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, catName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                SubCategory subCategory=new SubCategory(rs.getString(1), rs.getLong(2), CategoryDAO.findByName(rs.getString(3)));
                subCategorys.add(subCategory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subCategorys;
    }
    public static List<SubCategory> findAll() {
        sql = "SELECT `sub_category`.`name`,\n"
                + "    `sub_category`.`price`,\n"
                + "    `sub_category`.`cat_name`\n"
                + "FROM `milk_bar`.`sub_category`";
        List<SubCategory> subCategorys=new LinkedList<>();
        
        try (Connection con = DBConnect.getCon();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                SubCategory subCategory=new SubCategory(rs.getString(1), rs.getLong(2), CategoryDAO.findByName(rs.getString(3)));
                subCategorys.add(subCategory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subCategorys;
    }
    public static SubCategory findBySubCatName(String subCatName) {
        sql = "SELECT `sub_category`.`name`,\n"
                + "    `sub_category`.`price`,\n"
                + "    `sub_category`.`cat_name`\n"
                + "FROM `milk_bar`.`sub_category` where name=?;";
        SubCategory subCategory=new SubCategory();
        
        try (Connection con = DBConnect.getCon();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, subCatName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                subCategory=new SubCategory(rs.getString(1), rs.getLong(2), CategoryDAO.findByName(rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subCategory;
    }
    public static boolean save(SubCategory subCategory){
        boolean isSaved=false;
        sql="INSERT INTO `milk_bar`.`sub_category` (`name`,`price`,`cat_name`) VALUES (?,?,?);";
        
        try(Connection con = DBConnect.getCon();) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, subCategory.getName());
            ps.setLong(2, subCategory.getPrice());
            ps.setString(3, subCategory.getCategory().getName());
            isSaved=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }
    public static boolean update(SubCategory subCategory){
        boolean isSaved=false;
        sql="UPDATE `milk_bar`.`sub_category` SET `price` = ?,`cat_name` = ? WHERE `name` = ?;";
        try(Connection con = DBConnect.getCon();) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, subCategory.getPrice());
            ps.setString(2, subCategory.getCategory().getName());
            ps.setString(3, subCategory.getName());
            isSaved=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }
    public static boolean delete(String subCatName){
        sql="DELETE FROM `milk_bar`.`sub_category` WHERE name=?;";
        boolean isDel=false;
        try (Connection con = DBConnect.getCon();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, subCatName);
            isDel=!ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isDel;
    }
}
