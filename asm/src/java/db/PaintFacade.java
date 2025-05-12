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
        List<Paint> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Paint");
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
        con.close();
        return list;
    }

    public List<Paint> select(int page, int pageSize) throws SQLException {
        List<Paint> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Paint ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        stm.setInt(1, (page - 1) * pageSize);
        stm.setInt(2, pageSize);
        ResultSet rs = stm.executeQuery();
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
        con.close();
        return list;
    }

    public Paint select(int id) throws SQLException {
        Paint paint = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Paint WHERE id = ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
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
        con.close();
        return paint;
    }

    public int count() throws SQLException {
        int rowCount = 0;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT COUNT(*) AS rowCount FROM Paint");
        if (rs.next()) {
            rowCount = rs.getInt("rowCount");
        }
        con.close();
        return rowCount;
    }

    public void create(Paint paint) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Paint (color, colorName, hexadecimal, red, green, blue, price, discount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, paint.getColor());
        stm.setString(2, paint.getColorName());
        stm.setString(3, paint.getHexadecimal());
        stm.setInt(4, paint.getRed());
        stm.setInt(5, paint.getGreen());
        stm.setInt(6, paint.getBlue());
        stm.setDouble(7, paint.getPrice());
        stm.setDouble(8, paint.getDiscount());
        stm.executeUpdate();
        con.close();
    }

    public void delete(int id) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("DELETE FROM Paint WHERE id = ?");
        stm.setInt(1, id);
        stm.executeUpdate();
        con.close();
    }

    public void update(Paint paint) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Paint SET color=?, colorName=?, hexadecimal=?, red=?, green=?, blue=?, price=?, discount=? WHERE id=?");
        stm.setString(1, paint.getColor());
        stm.setString(2, paint.getColorName());
        stm.setString(3, paint.getHexadecimal());
        stm.setInt(4, paint.getRed());
        stm.setInt(5, paint.getGreen());
        stm.setInt(6, paint.getBlue());
        stm.setDouble(7, paint.getPrice());
        stm.setDouble(8, paint.getDiscount());
        stm.setInt(9, paint.getId());
        stm.executeUpdate();
        con.close();
    }
}
