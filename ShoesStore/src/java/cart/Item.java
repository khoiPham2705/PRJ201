package cart;

import db.Shoes;

public class Item {

    private int id;
    private Shoes shoes;
    private int quantity;
    private String size;

    public Item(int id, Shoes shoes, int quantity, String size) {
        this.id = id;
        this.shoes = shoes;
        this.quantity = quantity;
        this.size = size;
    }

    public Item(Shoes shoes, int quantity, String size) {
        this.id = shoes.getId();
        this.shoes = shoes;
        this.quantity = quantity;
        this.size = size;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getCost() {
        return quantity * shoes.getNewPrice();
    }

}
