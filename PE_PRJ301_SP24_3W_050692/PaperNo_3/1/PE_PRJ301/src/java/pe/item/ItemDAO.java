/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author LAPTOP
 */
public class ItemDAO {
    public List<ItemDTO> searchItem(String searchValue1, String searchValue2) throws SQLException, ClassNotFoundException {
        List<ItemDTO> itemList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            String sql = "SELECT * FROM tblItems WHERE price BETWEEN ? AND ?;";
            stm = con.prepareStatement(sql);
            stm.setString(1, searchValue1);
            stm.setString(2, searchValue2);

            rs = stm.executeQuery();
            while(rs.next()){
                ItemDTO product = new ItemDTO();
                product.setId(rs.getString("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
               
                itemList.add(product);
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return itemList;
    }
    public void remove(String id) throws SQLException, ClassNotFoundException{
            //tao ket noi db
            Connection con = DBUtils.getConnection();
            //tao doi tuong stm va thuc hien lenh select
            PreparedStatement stm = con.prepareStatement("DELETE FROM tblItems WHERE id = ?");
            //cung cap gia tri cho cac tham so
            stm.setString(1,id);
            //thuc hien lenh sql
            int count = stm.executeUpdate();
            //dong ket noi db
            con.close();
            
        
    }
    public List<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
    List<ItemDTO> list = new ArrayList<>();
    try (Connection con = DBUtils.getConnection();
         PreparedStatement stm = con.prepareStatement("SELECT * FROM tblItems");
         ResultSet rs = stm.executeQuery()) {
        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            list.add(new ItemDTO(id, name, price, quantity));
        }
    }
    return list;
}

}
