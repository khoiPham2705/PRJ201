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
            String sql = "SELECT * FROM tblProduct WHERE description LIKE ? ";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");

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
    public ProductDTO getProductById(String id) throws SQLException, ClassNotFoundException {
        ProductDTO product = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            String sql = "SELECT * FROM tblProduct WHERE id = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setSize(rs.getString("size"));
                product.setStatus(rs.getBoolean("status"));
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return product;
    }
    
    public boolean updateRoom(ProductDTO product) throws SQLException, ClassNotFoundException {
       boolean updated = false;
       Connection con = null;
       PreparedStatement stm = null;
       try {
           con = DBUtils.getConnection();
           String sql = "UPDATE tblProduct SET name = ?, description = ?, price = ?, size = ? WHERE id = ?";
           stm = con.prepareStatement(sql);
           stm.setString(1, product.getName());
           stm.setString(2, product.getDescription());
           stm.setDouble(3, product.getPrice());
           stm.setString(4, product.getSize());
           stm.setString(5, product.getId());
           updated = stm.executeUpdate() > 0;
       } finally {
           if (stm != null) stm.close();
           if (con != null) con.close();
       }
       return updated;
    }
    
    
    
    
}
