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
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author ACER
 * Cac phuong thuc truy cap vao table toy
 */
public class ToyFacade {

    /*
    Doc toan bo table toy
     */
    public List<Toy> select() throws SQLException {
        List<Toy> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Toy");
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong toy
            Toy toy = new Toy();
            toy.setId(rs.getString("Id"));
            toy.setName(rs.getString("Name"));
            toy.setPrice(rs.getDouble("Price"));
            toy.setExpDate(rs.getDate("ExpDate"));
            toy.setBrand(rs.getString("Brand"));
            // Them toy vao list
            list.add(toy);
        }
        // Close connection
        con.close();
        return list;
    }

    public void create(Toy toy) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("INSERT toy VALUES(?, ?, ?, ?, ?)");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, toy.getId());
        stm.setString(2, toy.getName());
        stm.setDouble(3, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(toy.getExpDate()));
        stm.setString(5, toy.getBrand());
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }
    public void delete(String id) throws SQLException{
            //tao ket noi db
            Connection con = DBContext.getConnection();
            //tao doi tuong stm va thuc hien lenh select
            PreparedStatement stm = con.prepareStatement("Delete toy where id = ?");
            //cung cap gia tri cho cac tham so
            stm.setString(1,id);
            //thuc hien lenh sql
            int count = stm.executeUpdate();
            //dong ket noi db
            con.close();
            
        
    }
    public Toy read(String id) throws SQLException{
            Toy toy = null;
            //tao ket noi db
            Connection con = DBContext.getConnection();
            //tao doi tuong stm va thuc hien lenh select
            PreparedStatement stm = con.prepareStatement("Select * from toy where id = ?");
            //cung cap gia tri cho cac tham so
            stm.setString(1,id);
            //thuc hien lenh sql
            ResultSet rs = stm.executeQuery();
           
       
        while (rs.next()) {
            // Doc row hien tai vao doi tuong toy
            toy = new Toy();
            toy.setId(rs.getString("Id"));
            toy.setName(rs.getString("Name"));
            toy.setPrice(rs.getDouble("Price"));
            toy.setExpDate(rs.getDate("ExpDate"));
            toy.setBrand(rs.getString("Brand"));
            // Them toy vao list
          
        }
        
            //dong ket noi db
            con.close();
            
        return toy;
    }
    public void update(Toy toy) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("Update Toy set Name=?, Price=?, expDate =?, Brand =? where id=?");
        // Cung cap gia tri cho cac tham so

        stm.setString(1, toy.getName());
        stm.setDouble(2, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(toy.getExpDate()));
        stm.setString(4, toy.getBrand());
        stm.setString(5, toy.getId());
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }
}