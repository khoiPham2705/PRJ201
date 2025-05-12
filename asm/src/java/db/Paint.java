package db;

public class Paint {
    private int id;
    private String color;
    private String colorName;
    private String hexadecimal;
    private int red;
    private int green;
    private int blue;
    private double price;
    private double discount;

    public Paint() {
    }

    public Paint(int id, String color, String colorName, String hexadecimal, int red, int green, int blue, double price, double discount) {
        this.id = id;
        this.color = color;
        this.colorName = colorName;
        this.hexadecimal = hexadecimal;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.price = price;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getColorName() {
        return colorName;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    
    
}



    

    