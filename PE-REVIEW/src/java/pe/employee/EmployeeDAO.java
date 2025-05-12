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

    public void create(String fullName, String dob, double salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<EmployeeDTO> searchEmployee(String searchValue) throws SQLException, ClassNotFoundException {
        List<EmployeeDTO> employeeList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            String sql = "SELECT * FROM Employee WHERE fullname LIKE ? ";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");

            rs = stm.executeQuery();
            while(rs.next()){
                EmployeeDTO employee = new EmployeeDTO();
                employee.setId(rs.getInt("id"));
                employee.setFullName(rs.getString("fullName"));
                employee.setDob(rs.getDate("Dob"));
                employee.setSalary(rs.getDouble("Salary"));
                
                employeeList.add(employee);
          
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return employeeList;
    }
    public void remove(String id) throws SQLException, ClassNotFoundException{
            //tao ket noi db
            Connection con = DBUtils.getConnection();
            //tao doi tuong stm va thuc hien lenh select
            PreparedStatement stm = con.prepareStatement("Delete employee where id = ?");
            //cung cap gia tri cho cac tham so
            stm.setString(1,id);
            //thuc hien lenh sql
            int count = stm.executeUpdate();
            //dong ket noi db
            con.close();
            
        
    }
    public List<EmployeeDTO> getAllEmployees() throws SQLException, ClassNotFoundException {
    List<EmployeeDTO> list = new ArrayList<>();
    try (Connection con = DBUtils.getConnection();
         PreparedStatement stm = con.prepareStatement("SELECT * FROM employee");
         ResultSet rs = stm.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("id");
            String fullName = rs.getString("fullName");
            Date dob = rs.getDate("dob");
            double salary = rs.getDouble("salary");
            
            list.add(new EmployeeDTO(id, fullName, (java.sql.Date) dob, salary));
        }
    }
    return list;
}
    
    
}
