/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author ACER
 */
public class Product {
    private int id;
    private String name;
    private String brand;
    private String category;
    private String size;
    private int price;
    private double discount;

    public Product() {
    }

    public Product(int id, String name, String brand, String category, String size, int price, double discount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.size = size;
        this.price = price;
        this.discount = discount;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public double getNewPrice() {
        return price * (1 - discount);
    }
    
    
   
}
