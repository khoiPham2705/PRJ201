package db;

import java.util.Date;

/*
Entity class
    - is a class same as a table in db
    - is java bean
    - aka ToyDTO
*/

public class Toy {
    private String id;
    private String name;
    private double price;
    private Date expDate;
    private String brand;

    public Toy() {
    }

    public Toy(String id, String name, double price, Date expDate, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expDate = expDate;
        this.brand = brand;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
}