

package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class productFacade {
    public List<Product> select() throws SQLException{
        List<Product> list = null;
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from Product");
        list = new ArrayList<>();
        while(rs.next()){
            //đọc dòng hiện hành vào đối tượng Product
            Product Product = new Product();
            Product.setId(rs.getInt("id"));
            Product.setDescription(rs.getString("description"));
            Product.setPrice(rs.getDouble("price"));
            Product.setDiscount(rs.getDouble("discount"));
            Product.setCategoryId(rs.getInt("categoryId"));
            //thêm brand vào list
            list.add(Product);
        }
        //đóng kết nối db
        con.close();
        return list;
    }
}
