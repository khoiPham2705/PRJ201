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
            // Doc row hien tai vao doi tuong brand
            Brand brand = new Brand();
            brand.setId(rs.getString("Id"));
            brand.setName(rs.getString("Name"));
            // Them brand vao list
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
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public void delete(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("DELETE brand WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public Brand read(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("SELECT * FROM brand WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();
        Brand brand = new Brand();

        while (rs.next()) {
            // Doc row hien tai vao doi tuong brand
            brand.setId(rs.getString("Id"));
            brand.setName(rs.getString("Name"));
        }

        // Close connection
        con.close();
        return brand;
    }

    public void update(Brand brand) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("UPDATE Brand SET Name=? WHERE id=?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, brand.getName());
        stm.setString(2, brand.getId());

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }
}
