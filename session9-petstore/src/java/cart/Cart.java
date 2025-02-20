

package cart;

import db.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Cart {
    private Map<Integer, Item> map = null;

    public Cart() {
        this.map = new HashMap<>();
    }
    
    //them item
    public void add(Product product, int quantity) {
        int id = product.getId();
        if (this.map.keySet().contains(id)) {
            //neu item da co trong danh sach thi tagn quantity;
            Item item = this.map.get(id);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            Item item = new Item(product, quantity);
            this.map.put(id, item);
        }
    }
    public Collection<Item> getItems() {
        
        return this.map.values();
    }
}
