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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPTOP
 */
public class BrandFacade {
    public List<Brand> select() throws SQLException {
        List<Brand> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Brand");
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong toy
            Brand brand = new Brand();
            brand.setId(rs.getString("Id"));
            brand.setName(rs.getString("Name"));
           
            // Them toy vao list
            list.add(brand);
        }
        // Close connection
        con.close();
        return list;
    }
    public void create(Brand brand) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("INSERT brand VALUES(?, ?)");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, brand.getId());
        stm.setString(2, brand.getName());
        
        stm.executeUpdate();

        // Close connection
        con.close();
    }
    public void delete(String id) throws SQLException{
            //tao ket noi db
            Connection con = DBContext.getConnection();
            //tao doi tuong stm va thuc hien lenh select
            PreparedStatement stm = con.prepareStatement("Delete brand where id = ?");
            //cung cap gia tri cho cac tham so
            stm.setString(1,id);
            //thuc hien lenh sql
            stm.executeUpdate();
            //dong ket noi db
            con.close();
            
        
    }
    public Brand read(String id) throws SQLException{
            Brand brand = null;
            //tao ket noi db
            Connection con = DBContext.getConnection();
            //tao doi tuong stm va thuc hien lenh select
            PreparedStatement stm = con.prepareStatement("Select * from brand where id = ?");
            //cung cap gia tri cho cac tham so
            stm.setString(1,id);
            //thuc hien lenh sql
            ResultSet rs = stm.executeQuery();
           
       
        while (rs.next()) {
            // Doc row hien tai vao doi tuong toy
            brand = new Brand();
            brand.setId(rs.getString("Id"));
            brand.setName(rs.getString("Name"));
            
            // Them toy vao list
          
        }
        
            //dong ket noi db
            con.close();
            
        return brand;
    }
    public void update(Brand brand) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("Update Brand set Name=? where id=?");
        // Cung cap gia tri cho cac tham so

        stm.setString(1, brand.getName());
       
        stm.setString(2, brand.getId());
        // Thuc hien lenh SQL
        stm.executeUpdate();

        // Close connection
        con.close();
    }
}
