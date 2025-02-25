package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountFacade {

    public Account login(String email, String password) throws SQLException {
        Account account = null;
        
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("SELECT * FROM account WHERE email = ? AND password = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, email);
        stm.setString(2, password);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            // Doc row hien tai vao doi tuong account
            account = new Account();
            account.setId(rs.getInt("Id"));
            account.setEmail(rs.getString("Email"));
            account.setPassword(rs.getString("Password"));
            account.setFullName(rs.getString("FullName"));
            account.setRole(rs.getString("Role"));
        }

        // Close connection
        con.close();
        return account;
    }
}