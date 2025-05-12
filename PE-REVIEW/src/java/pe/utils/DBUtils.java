package pe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Do not change this code
 */
public class DBUtils {

    //Create a connection from the application to the database server
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://localhost;databaseName=EmployeeManagement;user=sa;password=12345";
        //Loading a driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Creating a connection
        Connection con = DriverManager.getConnection(url);
        return con;
    }
}
