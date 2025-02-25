package cart;

import db.Product;
import java.util.Collection;
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
        if (map.keySet().contains(id)) {
            Item item = map.get(id);
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
            } else {
                map.remove(id);
            }
        }
    }
}