/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author LAPTOP
 */
public class ProductDAO {
    public List<ProductDTO> searchProduct(String searchValue) throws SQLException, ClassNotFoundException {
        List<ProductDTO> productList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            String sql = "SELECT * FROM tblProduct WHERE description LIKE ? and status like ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");
            stm.setString(2, "1");

            rs = stm.executeQuery();
            while(rs.next()){
                ProductDTO product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setSize(rs.getString("size"));
                product.setStatus(rs.getBoolean("status"));
                productList.add(product);
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return productList;
    }
    public void remove(String id) throws SQLException, ClassNotFoundException{
            //tao ket noi db
            Connection con = DBUtils.getConnection();
            //tao doi tuong stm va thuc hien lenh select
            PreparedStatement stm = con.prepareStatement("UPDATE tblProduct SET status = '0' WHERE id = ?");
            //cung cap gia tri cho cac tham so
            stm.setString(1,id);
            //thuc hien lenh sql
            int count = stm.executeUpdate();
            //dong ket noi db
            con.close();
            
        
    }
    public List<ProductDTO> getAllEmployees() throws SQLException, ClassNotFoundException {
    List<ProductDTO> list = new ArrayList<>();
    try (Connection con = DBUtils.getConnection();
         PreparedStatement stm = con.prepareStatement("SELECT * FROM employee");
         ResultSet rs = stm.executeQuery()) {
        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            String size = rs.getString("size");
            boolean status = rs.getBoolean("status");
            
            
            list.add(new ProductDTO(id, name, description,price,size,status));
        }
    }
    return list;
}
    
    
    
    
    
}
