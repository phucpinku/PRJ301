

package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public List<Product> select(int page, int pageSize) throws SQLException{
        List<Product> list = null;
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Product ORDER BY id offset ? rows fetch next ? rows only");
        stm.setInt(1, (page -1)* pageSize);
        stm.setInt(2, pageSize);
        ResultSet rs = stm.executeQuery();
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
    
    public Product select(int id) throws SQLException{
        Product product = null;
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Product WHERE id=?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            //đọc dòng hiện hành vào đối tượng Product
            product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        //đóng kết nối db
        con.close();
        return product;
    }
    
    public int count() throws SQLException{
        int rowCount = 0;
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select count(*) AS [rowCount] from Product");
        if(rs.next()){
            //đọc dòng hiện hành vào đối tượng Product
            
            rowCount= rs.getInt("rowCount");
            
        }
        //đóng kết nối db
        con.close();
        return rowCount;
    }
}
