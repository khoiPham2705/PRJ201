package pe.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    
    public UserDTO login(String userId, String password) throws ClassNotFoundException, SQLException {
        Connection con = DBUtils.getConnection();
        
        String sql = "SELECT * FROM tblUser WHERE userID = ? AND password = ?";
        
        PreparedStatement stm = con.prepareStatement(sql);
        
        stm.setString(1, userId);
        stm.setString(2, password);
        
        ResultSet rs = stm.executeQuery();
        
        UserDTO user = null;
        
        if(rs.next()) {
            user = new UserDTO();
            user.setName(rs.getString("name"));
            user.setUserID(rs.getString("userID"));
            user.setPassword(rs.getString("password"));
        }
        
        con.close();
        return user;
    }

}
