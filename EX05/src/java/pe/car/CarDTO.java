/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.car;

/**
 *
 * @author hd
 */
public class CarDTO {
    private int id;
    private String name;
    private String description;
    private double price;
    private int speed;
    private int status;

    public CarDTO() {
    }

    public CarDTO(int id, String name, String description, double price, int speed, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.speed = speed;
        this.status = status;
    }

    public int getId() {
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

    public int getSpeed() {
        return speed;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
}
