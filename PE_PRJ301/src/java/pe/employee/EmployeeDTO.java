package pe.employee;

import java.sql.Date;

public class EmployeeDTO {
    //your code here
    private int id;
    private String fullName;
    private Date Dob;
    private double Salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String fullName, Date Dob, float Salary) {
        this.id = id;
        this.fullName = fullName;
        this.Dob = Dob;
        this.Salary = Salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDob() {
        return Dob;
    }

    public double getSalary() {
        return Salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    
}
