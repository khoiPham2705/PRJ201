/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DBUtils;

/**
 *
 * @author LAPTOP
 */
public class UserDAO {
    public UserDTO login(String userId, String password) throws SQLException, ClassNotFoundException{
        UserDTO user = null;
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from tblUsers where userid = ? and password = ?");
        stm.setString(1, userId);
        stm.setString(2, password);
        
        ResultSet rs = stm.executeQuery();
        
        if(rs.next()){
            user = new UserDTO();
            user.setUserId(rs.getString("userId"));
            user.setFullName(rs.getString("fullName"));
            user.setPassword(rs.getString("password"));
            user.setRoleID(rs.getString("roleID"));
            user.setStatus(rs.getBoolean("status"));
            
        }
        con.close();
        return user;
        
    }
}
