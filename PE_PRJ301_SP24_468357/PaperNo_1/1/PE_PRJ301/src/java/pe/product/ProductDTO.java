/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.product;

/**
 *
 * @author LAPTOP
 */
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private double price;
    private String size;
    private boolean status;

    public ProductDTO() {
    }

    public ProductDTO(String id, String name, String description, double price, String size, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
