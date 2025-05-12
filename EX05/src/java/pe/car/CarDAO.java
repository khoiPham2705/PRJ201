/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.car;

import java.sql.Connection;
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
            car.setId(rs.getInt("id"));
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

  
    
}
