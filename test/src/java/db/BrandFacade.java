/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
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
}
