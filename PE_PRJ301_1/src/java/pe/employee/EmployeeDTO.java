package pe.employee;

import java.util.Date;

public class EmployeeDTO {
    //your code here
    private int id;
    private String fullName;
    private Date dob;
    private double salary;

    public EmployeeDTO(int id, String fullName, Date dob, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.salary = salary;
    }

    public EmployeeDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}