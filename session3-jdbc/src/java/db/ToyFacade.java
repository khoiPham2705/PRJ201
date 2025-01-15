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
 * @author ACER
 * Cac phuong thuc truy cap vao table toy
 */
public class ToyFacade {
    /**
     * Doc toan bo table toy
     */
    public List<Toy>select() throws SQLException{
        List<Toy> list= null;
        //Tao connection 
        Connection con=DBContext.getConnection();
        //Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm=con.createStatement();
        ResultSet rs=stm.executeQuery("SELECT * FROM Toy");
        list=new ArrayList<>();
        while(rs.next()){
            //Doc row hien tai vao doi tuong toy
            Toy toy=new Toy();
            toy.setId(rs.getString("Id"));
            toy.setName(rs.getString("Name"));
            toy.setBrand(rs.getString("Brand"));
            toy.setExpDate(rs.getDate("ExpDate"));
            toy.setPrice(rs.getDouble("Price"));
            // Them toy vao list
            list.add(toy);
        }
        con.close();
        return list;
    }
}