package pe.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.utils.DBUtils;

public class EmployeeDAO {
    //your code here
    public List<EmployeeDTO> select() throws SQLException, ClassNotFoundException {
        List<EmployeeDTO> list = null;

        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Employee");

        list = new ArrayList<>();

        while (rs.next()) {
            EmployeeDTO em = new EmployeeDTO();
            em.setId(rs.getInt("id"));
            em.setFullName(rs.getString("fullname"));
            em.setDob(rs.getDate("dob"));
            em.setSalary(rs.getDouble("salary"));
            
            list.add(em);
        }
        
        con.close();
        return list;
    }
    
    public void create(String fullName, Date dob, double salary) throws SQLException, ClassNotFoundException {

        Connection con = DBUtils.getConnection();

        PreparedStatement stm = con.prepareStatement("INSERT Employee VALUES(?, ?, ?)");

        stm.setString(1, fullName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(2, sdf.format(dob));
        stm.setDouble(3, salary);
        
        int count = stm.executeUpdate();
        
        con.close();
    }
    
}
