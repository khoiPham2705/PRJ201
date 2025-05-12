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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author LAPTOP
 */
public class UserDAO {
    public List<UserDTO> select() throws SQLException, ClassNotFoundException {
        List<UserDTO> list = null;

        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from tblUser");

        list = new ArrayList<>();
        while(rs.next()){
            UserDTO user = new UserDTO();
            user.setUsername(rs.getString("username"));
            user.setName(rs.getString("fullName"));
            user.setPassword(rs.getString("password"));
            list.add(user);
            
        
    }
        con.close();
        return list;
    }
    public UserDTO login(String username, String password) throws SQLException, ClassNotFoundException{
        UserDTO user = null;
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT * FROM tblUser WHERE username = ? AND password = ?");
        
        stm.setString(1,username);
        stm.setString(2, password);
        
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            user = new UserDTO();
            user.setUsername(rs.getString("username"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            
    }
        con.close();
        return user;
    }
    
    
    
}
