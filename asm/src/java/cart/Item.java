package cart;

import db.Paint;

public class Item {
    private int id;
    private Paint product;
    private int quantity;

    public Item(int id, Paint product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }
    
    public Item(Paint product, int quantity) {
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

    public Paint getProduct() {
        return product;
    }

    public void setProduct(Paint product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
//    public double getCost() {
//        return quantity * product.getNewPrice();
//    }
    
    
}