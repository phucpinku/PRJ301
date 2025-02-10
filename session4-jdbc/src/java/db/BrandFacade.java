/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHT
 */
public class BrandFacade {
    
    public List<Brand> select() throws SQLException{
        List<Brand> list = null;
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from Brand");
        list = new ArrayList<>();
        while(rs.next()){
            //đọc dòng hiện hành vào đối tượng brand
            Brand brand = new Brand();
            brand.setId(rs.getString("id"));
            brand.setName(rs.getString("name"));
            //thêm brand vào list
            list.add(brand);
        }
        //đóng kết nối db
        con.close();
        return list;
    }
}
