/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;
/**
 *
 * @author LAPTOP
 */
public class RoomDAO {
    public List<RoomDTO> searchRooms(String searchValue) throws SQLException, ClassNotFoundException {
        List<RoomDTO> roomList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            String sql = "SELECT * FROM tblRooms WHERE name LIKE ? AND status = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");
            stm.setBoolean(2, true);
            rs = stm.executeQuery();
            while(rs.next()){
                RoomDTO room = new RoomDTO();
                room.setId(rs.getString("id"));
                room.setName(rs.getString("name"));
                room.setDescription(rs.getString("description"));
                room.setPrice(rs.getDouble("price"));
                room.setArea(rs.getDouble("area"));
                room.setStatus(rs.getBoolean("status"));
                roomList.add(room);
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return roomList;
    }
    public RoomDTO getRoomById(String id) throws SQLException, ClassNotFoundException {
        RoomDTO room = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            String sql = "SELECT * FROM tblRooms WHERE id = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                room = new RoomDTO();
                room.setId(rs.getString("id"));
                room.setName(rs.getString("name"));
                room.setDescription(rs.getString("description"));
                room.setPrice(rs.getDouble("price"));
                room.setArea(rs.getDouble("area"));
                room.setStatus(rs.getBoolean("status"));
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return room;
    }
    
    public boolean updateRoom(RoomDTO room) throws SQLException, ClassNotFoundException {
       boolean updated = false;
       Connection con = null;
       PreparedStatement stm = null;
       try {
           con = DBUtils.getConnection();
           String sql = "UPDATE tblRooms SET name = ?, description = ?, price = ?, area = ? WHERE id = ?";
           stm = con.prepareStatement(sql);
           stm.setString(1, room.getName());
           stm.setString(2, room.getDescription());
           stm.setDouble(3, room.getPrice());
           stm.setDouble(4, room.getArea());
           stm.setString(5, room.getId());
           updated = stm.executeUpdate() > 0;
       } finally {
           if (stm != null) stm.close();
           if (con != null) con.close();
       }
       return updated;
    }
}
