/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class AccountFacade {
    public Account login(String email,String password) throws SQLException{
     Account account=null;
     
        //Tao connection 
        Connection con=DBContext.getConnection();
        //Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm=con.prepareStatement("Select * from account Where email=? AND password=?");
        // cung cap gia tri cho cac tham so
        stm.setString(1,email);
       stm.setString(2,password);
        //thuc hien lenh sql
  
        //Tao connection 
       
        ResultSet rs=stm.executeQuery();
        if(rs.next()){
            //Doc row hien tai vao doi tuong account
            account=new Account();
            account.setId(rs.getInt("Id"));
            account.setEmail(rs.getString("Email"));
            account.setPassword(rs.getString("Password"));
            account.setFullname(rs.getString("Fullname"));
            account.setRole(rs.getString("Role"));
            
            
        }
        con.close();
        return account;
 
    }
}
