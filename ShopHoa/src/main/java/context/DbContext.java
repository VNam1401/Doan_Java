package context;

import java.sql.*;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbContext {

    private static String DB_URL = "jdbc:mysql://localhost:3306/HoaTuoiDB";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sa";

    public static Connection getConnection() throws SQLException {
    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        System.out.println("connect successfully!");
    } catch (ClassNotFoundException e) {
        System.out.println("Driver class not found.");
        e.printStackTrace();
    }
    return conn; // trả về kết nối đã tạo
}
    public static void main(String[] args) throws SQLException {
        System.out.println("Ket Qua ket noi:" + DbContext.getConnection());
    }
}
//public class DbContext {
//
//    private static final String serverName = "PC233";
//    private static final String dbName = "HoaTuoiDB";
//    private static final String portNumber = "1433";
//    private static final String userID = "sa";
//    private static final String password = "sa";
//
//    public static Connection getConnection() {
//        Connection conn = null;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //b2. dinh nghia chuoi ket noi URL
//            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
//            //b3.Thiet lap ket noi
//            conn = DriverManager.getConnection(url, userID, password);
//        } catch (Exception ex) {
//            System.out.println("Error:" + ex.toString());
//        }
//        return conn;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Ket Qua ket noi:" + DbContext.getConnection());
//    }
//}
