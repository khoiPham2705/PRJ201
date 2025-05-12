package cart;

import db.OrderDetail;
import db.OrderHeader;
import db.OrderHeaderFacade;
import db.Product;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, Item> map = null;

    public Cart() {
        map = new HashMap<>();
    }

    public void add(Product product, int quantity) {
        int id = product.getId();
        if (map.keySet().contains(id)) {
            // Neu item da co trong cart thi + quantity
            Item item = map.get(id);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            // Neu chua co thi them item vao trong cart
//            Item item = new Item(product, quantity);
            map.put(id, new Item(product, quantity));

        }
    }

    public Collection<Item> getItems() {
        return map.values();
    }

    public Double getTotal() {
        double total = 0;
        for (Item item : this.map.values()) {
            total += item.getCost();
        }
        return total;
    }

    public void empty() {
        map.clear();
    }

    public void remove(int id) {
        map.remove(id);
    }

    public void update(int id, int quantity) {
        Item item = map.get(id);
        item.setQuantity(quantity);
    }

    public void checkout(int customerId) throws ClassNotFoundException, SQLException {
        Date date = new Date();
        int employeeId = 2;
        String status = "NEW";//NEW->SHIPPING->CANCEL,CLOSE
        OrderHeader oh = new OrderHeader(date, status, customerId, employeeId);

        for (Item item : this.getItems()) {
            OrderDetail od = new OrderDetail(item.getProduct().getId(), item.getQuantity(), item.getProduct().getPrice(), item.getProduct().getDiscount());
            oh.add(od);
        }

        OrderHeaderFacade ohf = new OrderHeaderFacade();
        ohf.insert(oh);
    }
}