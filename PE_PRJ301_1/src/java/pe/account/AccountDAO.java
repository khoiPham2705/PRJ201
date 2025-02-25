package pe.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

public class AccountDAO {

    //your code here
    public List<AccountDTO> select() throws SQLException, ClassNotFoundException {
        List<AccountDTO> list = null;

        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Account");

        list = new ArrayList<>();

        while (rs.next()) {
            AccountDTO acc = new AccountDTO();
            acc.setId(rs.getInt("id"));
            acc.setEmail(rs.getString("email"));
            acc.setFullName(rs.getString("fullName"));
            acc.setRoleID(rs.getString("roleID"));
            acc.setPassword(rs.getString("password"));
            list.add(acc);
        }

        con.close();
        return list;
    }

    public AccountDTO login(String email, String password) throws SQLException, ClassNotFoundException {
        AccountDTO acc = null;
        
        Connection con = DBUtils.getConnection();
        
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Account WHERE email = ? AND password = ?");
        
        stm.setString(1, email);
        stm.setString(2, password);
        
        ResultSet rs = stm.executeQuery();
        
        if(rs.next()) {
            acc = new AccountDTO();
            acc.setId(rs.getInt("id"));
            acc.setEmail(rs.getString("email"));
            acc.setFullName(rs.getString("fullName"));
            acc.setRoleID(rs.getString("roleId"));
            acc.setPassword(rs.getString("password"));
        }
        
        con.close();
        return acc;
    }
}