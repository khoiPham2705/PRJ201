package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaintFacade {

    public List<Paint> select() throws SQLException {
        List<Paint> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Product");
        list = new ArrayList<>();
        while (rs.next()) {
            Paint paint = new Paint();
            paint.setId(rs.getInt("id"));
            paint.setColor(rs.getString("color"));
            paint.setColorName(rs.getString("colorName"));
            paint.setHexadecimal(rs.getString("hexadecimal"));
            paint.setRed(rs.getInt("red"));
            paint.setGreen(rs.getInt("green"));
            paint.setBlue(rs.getInt("blue"));
            paint.setPrice(rs.getDouble("price"));
            paint.setDiscount(rs.getDouble("discount"));
            list.add(paint);
        }
        // Close connection
        con.close();
        return list;
    }

    public List<Paint> select(int page, int pageSize) throws SQLException {
        List<Paint> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Product ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        stm.setInt(1, (page - 1) * pageSize);
        stm.setInt(2, pageSize);

        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong paint
            Paint paint = new Paint();
            paint.setId(rs.getInt("id"));
            paint.setColor(rs.getString("color"));
            paint.setColorName(rs.getString("colorName"));
            paint.setHexadecimal(rs.getString("hexadecimal"));
            paint.setRed(rs.getInt("red"));
            paint.setGreen(rs.getInt("green"));
            paint.setBlue(rs.getInt("blue"));
            paint.setPrice(rs.getDouble("price"));
            paint.setDiscount(rs.getDouble("discount"));
            list.add(paint);
        }
        // Close connection
        con.close();
        return list;
    }
    
    public Paint select(int id) throws SQLException {
        Paint paint = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Product WHERE id = ?");

        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // Doc row hien tai vao doi tuong paint
            paint = new Paint();
            paint.setId(rs.getInt("id"));
            paint.setColor(rs.getString("color"));
            paint.setColorName(rs.getString("colorName"));
            paint.setHexadecimal(rs.getString("hexadecimal"));
            paint.setRed(rs.getInt("red"));
            paint.setGreen(rs.getInt("green"));
            paint.setBlue(rs.getInt("blue"));
            paint.setPrice(rs.getDouble("price"));
            paint.setDiscount(rs.getDouble("discount"));
      
        }
        // Close connection
        con.close();
        return paint;
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

    public void create(Paint paint) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("INSERT paint VALUES(?, ?, ?, ?)");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, paint.getDescription());
        stm.setDouble(2, paint.getPrice());
        stm.setDouble(3, paint.getDiscount());
        stm.setInt(4, paint.getCategoryId());
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public void delete(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("DELETE paint WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public Paint read(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("SELECT * FROM paint WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();
        Paint paint = new Paint();

        while (rs.next()) {
            // Doc row hien tai vao doi tuong paint
            paint.setId(rs.getInt("id"));
            paint.setDescription(rs.getString("description"));
            paint.setPrice(rs.getDouble("price"));
            paint.setDiscount(rs.getDouble("discount"));
            paint.setCategoryId(rs.getInt("categoryId"));
        }

        // Close connection
        con.close();
        return paint;
    }

    public void update(Paint paint) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("UPDATE Product SET Description=?, Price=?, Discount=?, CategoryId=? WHERE id=?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, paint.getDescription());
        stm.setDouble(2, paint.getPrice());
        stm.setDouble(3, paint.getDiscount());
        stm.setInt(4, paint.getCategoryId());

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }
}