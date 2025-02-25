package cart;

import db.Product;

public class Item {
    private int id;
    private Product product;
    private int quantity;

    public Item(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }
    
    public Item(Product product, int quantity) {
        this.id = product.getId();
        this.product = product;
        this.quantity = quantity;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getCost() {
        return quantity * product.getNewPrice();
    }
    
    
}