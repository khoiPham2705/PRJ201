package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RevenueFacade {

    public Revenue getByDay(int day, int month, int year) throws SQLException {
        Connection con = DBContext.getConnection();

        String sql = "SELECT \n"
                + "    SUM(od.quantity * (od.price * (1 - od.discount))) AS revenue\n"
                + "FROM \n"
                + "    OrderDetail od\n"
                + "JOIN \n"
                + "    OrderHeader oh ON od.orderHeaderId = oh.id\n"
                + "WHERE \n"
                + "    DAY(oh.date) = " + day + " AND MONTH(oh.date) = " + month + " AND YEAR(oh.date) = " + year;

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        Revenue rev = null;

        if (rs.next()) {
            rev = new Revenue();
            rev.setDay(day);
            rev.setMonth(month);
            rev.setYear(year);
            rev.setRevenue(rs.getDouble("revenue"));
        }

        con.close();
        return rev;
    }

    public Revenue getByMonth(int month, int year) throws SQLException {
        Connection con = DBContext.getConnection();

        String sql = "SELECT \n"
                + "    SUM(od.quantity * (od.price * (1 - od.discount))) AS revenue\n"
                + "FROM \n"
                + "    OrderDetail od\n"
                + "JOIN \n"
                + "    OrderHeader oh ON od.orderHeaderId = oh.id\n"
                + "WHERE \n"
                + "    MONTH(oh.date) = " + month + " AND YEAR(oh.date) = " + year;

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        Revenue rev = null;

        if (rs.next()) {
            rev = new Revenue();
            rev.setMonth(month);
            rev.setYear(year);
            rev.setRevenue(rs.getDouble("revenue"));
        }

        con.close();
        return rev;
    }

    public Revenue getByYear(int year) throws SQLException {
        Connection con = DBContext.getConnection();

        String sql = "SELECT \n"
                + "    SUM(od.quantity * (od.price * (1 - od.discount))) AS revenue\n"
                + "FROM \n"
                + "    OrderDetail od\n"
                + "JOIN \n"
                + "    OrderHeader oh ON od.orderHeaderId = oh.id\n"
                + "WHERE \n"
                + "    YEAR(oh.date) = " + year;

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        Revenue rev = null;

        if (rs.next()) {
            rev = new Revenue();
            rev.setYear(year);
            rev.setRevenue(rs.getDouble("revenue"));
        }

        con.close();
        return rev;
    }

    public List<Revenue> getPrevious7Day(int day, int month, int year) throws SQLException {
        Connection con = DBContext.getConnection();

        // Create a date object for the chosen date
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Months are 0-based in Java
        Date endDate = calendar.getTime();
        // Calculate the date 7 days ago
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date startDate = calendar.getTime();

        // Format dates for SQL query
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr = sdf.format(startDate);
        String endDateStr = sdf.format(endDate);

        String sql = "SELECT \n"
                + "    DAY(oh.date) AS day,\n"
                + "    MONTH(oh.date) AS month,\n"
                + "    YEAR(oh.date) AS year,\n"
                + "    SUM(od.quantity * (od.price * (1 - od.discount))) AS revenue\n"
                + "FROM \n"
                + "    OrderDetail od\n"
                + "JOIN \n"
                + "    OrderHeader oh ON od.orderHeaderId = oh.id\n"
                + "WHERE \n"
                + "    oh.date BETWEEN '" + startDateStr + "' AND '" + endDateStr + "'\n"
                + "GROUP BY \n"
                + "    DAY(oh.date), MONTH(oh.date), YEAR(oh.date)\n"
                + "ORDER BY \n"
                + "    DAY(oh.date);";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        List<Revenue> list = new ArrayList<>();

        while (rs.next()) {
            Revenue rev = new Revenue();
            rev.setDay(rs.getInt("day"));
            rev.setMonth(rs.getInt("month"));
            rev.setYear(rs.getInt("year"));
            rev.setRevenue(rs.getDouble("revenue"));

            list.add(rev);
        }

        con.close();
        return list;
    }

}
