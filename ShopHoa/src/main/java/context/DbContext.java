package context;
import java.sql.*;

public class DbContext {
    
    private static final String serverName = "localhost:3306";
    private static final String dbName = "HoaTuoiDB";
    private static final String portNumber = "1433"; 
    private static final String userID = "sa";
    private static final String password = "sa";
    
    public static Connection getConnection() throws SQLException
    {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(serverName, dbName, password);
            System.out.println("connect successfully!");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Loi");
            e.printStackTrace();
        }
        return DriverManager.getConnection(serverName, dbName, password);
    }
}
