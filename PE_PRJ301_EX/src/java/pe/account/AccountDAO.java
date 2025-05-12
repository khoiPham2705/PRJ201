package pe.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pe.utils.DBUtils;

public class AccountDAO {
    //your code here
    public List <AccountDTO> select() throws SQLException, ClassNotFoundException{
        List <AccountDTO> list = null;
        
        Connection con = DBUtils.getConnection();
        
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from account");
        
        list = new ArrayList<>();
        
        while(rs.next()){
            AccountDTO acc = new AccountDTO();
            acc.setId(rs.getInt("id"));
            acc.setEmail(rs.getString("email"));
            acc.setFullName(rs.getString("fullName"));
            acc.setRoleId(rs.getString("roleId"));
            acc.setPassword(rs.getString("password"));
            
            
        }
        con.close();
        return list;
        
    }
    public AccountDTO login(String email, String password) throws SQLException, ClassNotFoundException{
        
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT * FROM account WHERE email = ? AND password = ?");
        stm.setString(1, email);
        stm.setString(2, password);
        
        ResultSet rs = stm.executeQuery();
        AccountDTO account = null;
        if (rs.next()) {
            account = new AccountDTO();
            account.setId(rs.getInt("Id"));
            account.setEmail(rs.getString("email"));
            account.setFullName(rs.getString("fullName"));
            account.setRoleId(rs.getString("roleId"));
            account.setPassword(rs.getString("password"));
            
            
        }

        // Close connection
        con.close();
        return account;
    }
    
}
