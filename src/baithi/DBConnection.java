package baithi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        String dbURL = "jdbc:mysql://localhost:3306/AddressBookDB";
        conn = DriverManager.getConnection(dbURL,"root","");
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Kết nối thành công");
        }
    }
}
