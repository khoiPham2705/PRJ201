package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            // Doc row hien tai vao doi tuong product
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
            // Them product vao list
            list.add(product);
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
            // Doc row hien tai vao doi tuong product
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
            // Them product vao list
            list.add(product);
        }
        // Close connection
        con.close();
        return list;
    }
    
    public Product select(int id) throws SQLException {
        Product product = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Product WHERE id = ?");

        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // Doc row hien tai vao doi tuong product
            product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        // Close connection
        con.close();
        return product;
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

    public void create(Product product) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("INSERT product VALUES(?, ?, ?, ?)");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, product.getDescription());
        stm.setDouble(2, product.getPrice());
        stm.setDouble(3, product.getDiscount());
        stm.setInt(4, product.getCategoryId());
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public void delete(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("DELETE product WHERE id = ?");
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
        PreparedStatement stm = con.prepareStatement("SELECT * FROM product WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();
        Product product = new Product();

        while (rs.next()) {
            // Doc row hien tai vao doi tuong product
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
        }

        // Close connection
        con.close();
        return product;
    }

    public void update(Product product) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("UPDATE Product SET Description=?, Price=?, Discount=?, CategoryId=? WHERE id=?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, product.getDescription());
        stm.setDouble(2, product.getPrice());
        stm.setDouble(3, product.getDiscount());
        stm.setInt(4, product.getCategoryId());

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }
}