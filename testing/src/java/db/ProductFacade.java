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
 * @author ACER
 */
public class ProductFacade {

    public List<Product> select() throws SQLException {
        List<Product> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Product");
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong shoes
            Product shoes = new Product();
            shoes.setId(rs.getInt("id"));
            shoes.setName(rs.getString("name"));
            shoes.setBrand(rs.getString("brand"));
            shoes.setCategory(rs.getString("category"));
            shoes.setSize(rs.getString("size"));
            shoes.setPrice(rs.getInt("price"));
            shoes.setDiscount(rs.getDouble("discount"));
            // Them shoes vao list
            list.add(shoes);
        }
        // Close connection
        con.close();
        return list;
    }

    public List<Product> select(int page, int pageSize) throws SQLException {
        List<Product> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Product ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        stm.setInt(1, (page - 1) * pageSize);
        stm.setInt(2, pageSize);

        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong shoes
            Product shoes = new Product();
            shoes.setId(rs.getInt("id"));
            shoes.setName(rs.getString("name"));
            shoes.setBrand(rs.getString("brand"));
            shoes.setCategory(rs.getString("category"));
            shoes.setSize(rs.getString("size"));
            shoes.setPrice(rs.getInt("price"));
            shoes.setDiscount(rs.getDouble("discount"));
            // Them shoes vao list
            list.add(shoes);
        }
        // Close connection
        con.close();
        return list;
    }

    public Product select(int id) throws SQLException {
        Product shoes = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Product WHERE id = ?");

        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // Doc row hien tai vao doi tuong shoes
            shoes = new Product();
            shoes.setId(rs.getInt("id"));
            shoes.setName(rs.getString("name"));
            shoes.setBrand(rs.getString("brand"));
            shoes.setCategory(rs.getString("category"));
            shoes.setSize(rs.getString("size"));
            shoes.setPrice(rs.getInt("price"));
            shoes.setDiscount(rs.getDouble("discount"));
        }
        // Close connection
        con.close();
        return shoes;
    }

    public int count() throws SQLException {

        int rowCount = 0;

        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT COUNT(*) AS [rowCount] FROM Product");
        if (rs.next()) {
            rowCount = rs.getInt("rowCount");
        }
        // Close connection
        con.close();
        return rowCount;
    }

    public void create(Product shoes) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("INSERT shoes VALUES(?, ?, ?, ?, ?, ?)");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, shoes.getName());
        stm.setString(2, shoes.getBrand());
        stm.setString(3, shoes.getCategory());
        stm.setString(4, shoes.getSize());
        stm.setInt(5, shoes.getPrice());
        stm.setDouble(6, shoes.getDiscount());

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public void delete(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("DELETE shoes WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public Product read(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("SELECT * FROM shoes WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();
        Product shoes = new Product();

        while (rs.next()) {
            // Doc row hien tai vao doi tuong shoes
            shoes.setId(rs.getInt("id"));
            shoes.setName(rs.getString("name"));
            shoes.setBrand(rs.getString("brand"));
            shoes.setCategory(rs.getString("category"));
            shoes.setSize(rs.getString("size"));
            shoes.setPrice(rs.getInt("price"));
            shoes.setDiscount(rs.getDouble("discount"));
        }

        // Close connection
        con.close();
        return shoes;
    }

    public void update(Product shoes) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("UPDATE Product SET Name=?, Brand=?, Category=?, Size=?, Price=?, Discount=? WHERE id=?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, shoes.getName());
        stm.setString(2, shoes.getBrand());
        stm.setString(3, shoes.getCategory());
        stm.setString(4, shoes.getSize());
        stm.setInt(5, shoes.getPrice());
        stm.setDouble(6, shoes.getDiscount());
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }
}
