package milkbar.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnect {
    private final static String USER_NAME="root";
    private final static String PASSWORD="hp15p251nz";
    private final static String URL="jdbc:mysql://localhost:3306/milk_bar";
    public static Connection getCon(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MariaDB Connection Failed");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Driver Not Loaded");
        }
        return con;
    }
}
