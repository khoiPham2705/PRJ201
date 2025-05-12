package pe.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HouseDAO {

    public List<HouseDTO> list() throws ClassNotFoundException, SQLException {
        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();

        String sql = "SELECT * FROM tblHouse";

        ResultSet rs = stm.executeQuery(sql);

        List<HouseDTO> list = new ArrayList<>();

        while (rs.next()) {
            HouseDTO house = new HouseDTO();
            house.setId(rs.getString("id"));
            house.setName(rs.getString("name"));
            house.setDescription(rs.getString("description"));
            house.setPrice(rs.getDouble("price"));
            house.setSize(rs.getDouble("size"));
            house.setStatus(rs.getBoolean("status"));

            list.add(house);
        }

        con.close();
        return list;
    }

    public List<HouseDTO> search(String keyword) throws ClassNotFoundException, SQLException {
        Connection con = DBUtils.getConnection();

        String sql = "SELECT * FROM tblHouse WHERE name LIKE '%" + keyword + "%'";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        List<HouseDTO> list = new ArrayList<>();

        while (rs.next()) {
            HouseDTO house = new HouseDTO();
            house.setId(rs.getString("id"));
            house.setName(rs.getString("name"));
            house.setDescription(rs.getString("description"));
            house.setPrice(rs.getDouble("price"));
            house.setSize(rs.getDouble("size"));
            house.setStatus(rs.getBoolean("status"));

            list.add(house);
        }

        con.close();
        return list;
    }

    public void delete(String id) throws ClassNotFoundException, SQLException {
        Connection con = DBUtils.getConnection();

        String sql = "UPDATE tblHouse SET status='0' WHERE id = '" + id + "'";

        PreparedStatement stm = con.prepareStatement(sql);

//        stm.setString(1, id);

        int count = stm.executeUpdate();
    }

}
