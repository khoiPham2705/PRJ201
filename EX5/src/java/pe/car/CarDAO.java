/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.car;

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
 * @author hd
 */
public class CarDAO {

//   your code here
    public List<CarDTO> select() throws SQLException, ClassNotFoundException {
        List<CarDTO> list = null;

        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from tblCars");

        list = new ArrayList<>();
        while(rs.next()){
            CarDTO car = new CarDTO();
            car.setId(rs.getString("id"));
            car.setName(rs.getString("name"));
            car.setDescription(rs.getString("description"));
            car.setPrice(rs.getDouble("price"));
            car.setSpeed(rs.getInt("speed"));
            car.setStatus(rs.getInt("status"));
            list.add(car);
            
        
    }
        con.close();
        return list;
    }
    public void create(String id,String name,String description,double price,int speed,int status) throws SQLException, ClassNotFoundException {

        Connection con = DBUtils.getConnection();

        PreparedStatement stm = con.prepareStatement("INSERT INTO tblCars (id, name, description, price, speed, status) VALUES (?, ?, ?, ?, ?, ?)");

        stm.setString(1, id);
        stm.setString(2, name);
        stm.setString(3, description);
        stm.setDouble(4, price);
        stm.setInt(5, speed);
        stm.setInt(6, status);
        
        
        int count = stm.executeUpdate();
        
        con.close();
    }
    public boolean isCarIDExists(String id) throws SQLException, ClassNotFoundException {
    Connection con = DBUtils.getConnection();
    PreparedStatement stm = con.prepareStatement("SELECT COUNT(*) FROM tblCars WHERE id = ?");
    stm.setString(1, id);
    
    ResultSet rs = stm.executeQuery();
    boolean exists = false;
    if (rs.next()) {
        exists = rs.getInt(1) > 0;
    }
    
    con.close();
    return exists;
}
    
  
    
}
