package db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderHeader {

    private int id;
    private Date date;
    private String status;
    private int accountId;
    private List<OrderDetail> details = null;

    public OrderHeader() {
        this.details = new ArrayList<>();
    }

    public OrderHeader(Date date, String status, int accountId) {
        this.date = date;
        this.status = status;
        this.accountId = accountId;
        this.details = new ArrayList<>();
    }

    public OrderHeader(int id, Date date, String status, int accountId) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.accountId = accountId;
        this.details = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public void add(OrderDetail orderDetail) {
        this.details.add(orderDetail);
    }
}
