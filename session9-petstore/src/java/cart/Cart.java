

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
    
    public double getTotal() {
        double total = 0;
        for (Item item: this.map.values()) {
            total += item.getCost();
        }
        
        return total;
    }
    
    public void remove(int id) {
        this.map.remove(id);
    }
    
    public void empty() {
        this.map.clear();
    }
    
    public void update(int id, int quantity) {
        Item item = this.map.get(id);
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
