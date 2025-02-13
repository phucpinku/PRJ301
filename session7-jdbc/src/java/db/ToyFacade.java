/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHT
 * Cung cấp các phương thức truy cập table Toy
 * Có thể đặt tên là ToyDAO
 */
public class ToyFacade {
    /**
     * Đọc toàn bộ table Toy
     */
    public List<Toy> select() throws SQLException{
        List<Toy> list = null;
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from Toy");
        list = new ArrayList<>();
        while(rs.next()){
            //đọc dòng hiện hành vào đối tượng toy
            Toy toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getDouble("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrand(rs.getString("brand"));
            //thêm toy vào list
            list.add(toy);
        }
        //đóng kết nối db
        con.close();
        return list;
    }
    
    public void create(Toy toy) throws SQLException{
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        PreparedStatement stm = con.prepareStatement("insert Toy values(?,?,?,?,?)");
        //cung cấp giá trị cho các tham số
        stm.setString(1, toy.getId());
        stm.setString(2, toy.getName());
        stm.setDouble(3, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(toy.getExpDate()));
        stm.setString(5, toy.getBrand());
        //thực hiện lệnh sql
        int count = stm.executeUpdate();        
        //đóng kết nối db
        con.close();
    }
    
    public void delete(String id) throws SQLException{
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        PreparedStatement stm = con.prepareStatement("delete Toy where id = ?");
        //cung cấp giá trị cho các tham số
        stm.setString(1, id);
        //thực hiện lệnh sql
        int count = stm.executeUpdate();        
        //đóng kết nối db
        con.close();
    }
    
    public Toy read(String id) throws SQLException{
        Toy toy = null;
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        PreparedStatement stm = con.prepareStatement("select * from Toy where id = ?");
        //cung cấp giá trị cho các tham số
        stm.setString(1, id);
        //thực hiện lệnh sql
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            //đọc dòng hiện hành vào đối tượng toy
            toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getDouble("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrand(rs.getString("brand"));
        }      
        //đóng kết nối db
        con.close();
        return toy;
    }
    
    public void update(Toy toy) throws SQLException{
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        PreparedStatement stm = con.prepareStatement("update Toy set Name=?, Price=?, expDate=?, brand=? where id=?");
        //cung cấp giá trị cho các tham số        
        stm.setString(1, toy.getName());
        stm.setDouble(2, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(toy.getExpDate()));
        stm.setString(4, toy.getBrand());
        stm.setString(5, toy.getId());
        //thực hiện lệnh sql
        int count = stm.executeUpdate();        
        //đóng kết nối db
        con.close();
    }
}
