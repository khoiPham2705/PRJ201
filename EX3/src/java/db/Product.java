/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.Date;

/**
 *
 * @author LAPTOP
 */
public class Product {
    private String id;
    private String name;
    private double price;
    private Date expDate;

    public Product() {
    }

    public Product(String id, String name, double price, Date expDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expDate = expDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
    
    
    
}
