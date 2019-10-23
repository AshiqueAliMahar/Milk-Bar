package milkbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import milkbar.db.connection.DBConnect;
import milkbar.model.Authorization;
import milkbar.model.User;

public class UsersDAO {

    private static String sql = "";

    public static User getUser(String email, String password) {
        User user = new User();
        sql = "SELECT `users`.`email`,\n"
                + "    `users`.`name`,\n"
                + "    `users`.`password`,\n"
                + "    `users`.`authorization`\n"
                + "FROM `milk_bar`.`users` where email=? and password=?;";
        Connection con = DBConnect.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int i = 1;
                String emailString = rs.getString(i++);
                String nameString = rs.getString(i++);
                String passwordString = rs.getString(i++);
                String authorizationString = rs.getString(i++);
                user.setEmail(emailString);
                user.setName(nameString);
                user.setPassword(passwordString);
                user.setAuthorization(authorizationString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static boolean update(User user) {
        boolean isUpdated = false;
        sql = "UPDATE `milk_bar`.`users`\n"
                + "SET\n"
                + "`email` = ?,\n"
                + "`name` = ?,\n"
                + "`password` = ?,\n"
                + "`authorization` = ?\n"
                + "WHERE `email` = ?";
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(5, user.getEmail());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAuthorization().toString());
            isUpdated = !ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    public static User findById(String email) {
        User user = new User();
        sql = "SELECT `users`.`email`,\n"
                + "    `users`.`name`,\n"
                + "    `users`.`password`,\n"
                + "    `users`.`authorization`\n"
                + "FROM `milk_bar`.`users` where email=?;";
        try {
            PreparedStatement ps = DBConnect.getCon().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                user=new User(rs.getString(1), rs.getString(2), rs.getString(3), Authorization.Admin);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
