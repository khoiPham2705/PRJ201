package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderHeaderFacade {

    public void insert(OrderHeader orderHeader) throws ClassNotFoundException, SQLException {
        //Tao ket noi database
        Connection con = DBContext.getConnection();

        try {
            //Bắt đầu transaction
            con.setAutoCommit(false);
            //Insert data vào table OrderHeader
            PreparedStatement stm = con.prepareStatement(
                    "INSERT INTO OrderHeader VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            stm.setString(1, sdf.format(orderHeader.getDate()));
            stm.setString(3, orderHeader.getStatus());
            stm.setInt(2, orderHeader.getAccountId());
            int count = stm.executeUpdate();

            //Lấy account id được phát sinh tự động
            try (ResultSet rs = stm.getGeneratedKeys()) {
                if (rs.next()) {
                    orderHeader.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting order failed.");
                }
            }

            //Insert data vào table OrderDetail
            stm = con.prepareStatement("insert into OrderDetail values(?, ?, ?, ?, ?, ?, ?, ?)");
            for (OrderDetail orderDetail : orderHeader.getDetails()) {
                stm.setInt(1, orderHeader.getId());
                stm.setInt(2, orderDetail.getShoesId());
                stm.setInt(3, orderDetail.getQuantity());
                stm.setDouble(4, orderDetail.getPrice());
                stm.setDouble(5, orderDetail.getDiscount());
                stm.setString(6, orderDetail.getAddress());
                stm.setString(7, orderDetail.getPhone());
                stm.setInt(8, orderDetail.getSize());
                count = stm.executeUpdate();
            }
            //Kết thúc transaction
            con.commit();
        } catch (SQLException ex) {
            try {
                //Undo transaction
                con.rollback();
                System.out.println("ROLL BACK");
            } catch (SQLException ex1) {
                throw ex1;
            }
            throw ex;
        }

        //Dong ket noi database
        con.close();
    }

    public void update(OrderHeader orderheader) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("UPDATE OrderHeader SET  status=? WHERE id=?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, orderheader.getStatus());
        stm.setInt(2, orderheader.getId());
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public OrderHeader read(int id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("SELECT * FROM orderheader WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setInt(1, id);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();
        OrderHeader oh = new OrderHeader();

        while (rs.next()) {

            oh.setId(rs.getInt("id"));
            oh.setDate(rs.getDate("date"));
            oh.setAccountId(rs.getInt("accountId"));
            oh.setStatus(rs.getString("status"));
        }

        // Close connection
        con.close();
        return oh;

    }

    public List<OrderHeader> select() throws SQLException {
        List<OrderHeader> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM OrderHeader");
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong orderheader
            OrderHeader orderheader = new OrderHeader();
            orderheader.setId(rs.getInt("id"));
            orderheader.setDate(rs.getDate("date"));
            orderheader.setAccountId(rs.getInt("accountId"));
            orderheader.setStatus(rs.getString("status"));
            // Them orderheader vao list
            list.add(orderheader);
        }
        // Close connection
        con.close();
        return list;
    }

    public OrderHeader select(int id) throws SQLException {
        OrderHeader orderheader = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT * FROM OrderHeader WHERE id = ?");

        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // Doc row hien tai vao doi tuong orderheader
            orderheader = new OrderHeader();
            orderheader.setId(rs.getInt("id"));
            orderheader.setDate(rs.getDate("date"));
            orderheader.setAccountId(rs.getInt("accountId"));
            orderheader.setStatus(rs.getString("status"));
        }
        // Close connection
        con.close();
        return orderheader;
    }

    public int count() throws SQLException {

        int rowCount = 0;

        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT COUNT(*) AS [rowCount] FROM OrderHeader");
        if (rs.next()) {
            rowCount = rs.getInt("rowCount");
        }
        // Close connection
        con.close();
        return rowCount;
    }
}
