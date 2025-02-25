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
public class PaintStoreFacade {
public List<PaintStore> select() throws SQLException {
        List<PaintStore> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM PaintStore");
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong paint
            PaintStore paint = new PaintStore();
            paint.setId(rs.getInt("id"));
          
            paint.setPrice(rs.getDouble("price"));
            paint.setDiscount(rs.getDouble("discount"));
       
            // Them paint vao list
            list.add(paint);
        }
        // Close connection
        con.close();
        return list;
    }
    

}
