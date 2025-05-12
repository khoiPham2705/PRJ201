package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountFacade {

    public Account login(String email, String password) throws SQLException {
        Account account = null;

        //Tao connection 
        Connection con = DBContext.getConnection();
        //Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("Select * from account Where email=? AND password=?");
        // cung cap gia tri cho cac tham so
        stm.setString(1, email);
        stm.setString(2, password);
        //thuc hien lenh sql

        //Tao connection 
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            //Doc row hien tai vao doi tuong account
            account = new Account();
            account.setId(rs.getInt("Id"));
            account.setEmail(rs.getString("Email"));
            account.setPassword(rs.getString("Password"));
            account.setFullname(rs.getString("Fullname"));
            account.setRole(rs.getString("Role"));

        }
        con.close();
        return account;

    }

    public boolean register(String email, String password, String fullName) throws SQLException {
        // Kiểm tra xem email đã tồn tại chưa
        if (isEmailExists(email)) {
            return false; // Email đã tồn tại, không thể đăng ký
        }

        String query = "INSERT INTO account (Email, Password, Fullname, Role) VALUES (?, ?, ?, 'USER')";

        try (Connection con = DBContext.getConnection();
                PreparedStatement stm = con.prepareStatement(query)) {

            stm.setString(1, email);
            stm.setString(2, password);
            stm.setString(3, fullName);

            int rowsInserted = stm.executeUpdate();
            return rowsInserted > 0;  // Trả về true nếu đăng ký thành công
        }
    }

    private boolean isEmailExists(String email) throws SQLException {
        String query = "SELECT 1 FROM account WHERE Email = ?";

        try (Connection con = DBContext.getConnection();
                PreparedStatement stm = con.prepareStatement(query)) {

            stm.setString(1, email);
            try (ResultSet rs = stm.executeQuery()) {
                return rs.next(); // Nếu có kết quả, email đã tồn tại
            }
        }
    }
}
