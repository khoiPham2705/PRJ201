package db;

public class Revenue {

    private int day;
    private int month;
    private int year;
    private double revenue;

    public Revenue(int day, int month, int year, double revenue) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.revenue = revenue;
    }

    public Revenue() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.revenue = 0;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

}
