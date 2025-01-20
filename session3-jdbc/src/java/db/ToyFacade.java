

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
 * 
 * @author ACER
 * provide methods to access to table Toy
 * can be name as ToyDAO
 */

public class ToyFacade {
    /**
     * Read all of Toy table
     */
    public List<Toy> select() throws SQLException {
        List<Toy> list = null;
        //create connection to db
        Connection con = DBContext.getConnection();
        //create object stm and execute select command
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from Toy");
        list = new ArrayList<>();
        while(rs.next()) {
            //read(add) current row to object toy
            Toy toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getInt("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrand(rs.getString("brand"));
            list.add(toy);
        }
        //close connection to db
        con.close();
        return list;
    }
    
    public void create(Toy toy) throws SQLException {
        //create connection to db
        Connection con = DBContext.getConnection();
        //create object stm and execute select command
        PreparedStatement stm = con.prepareStatement("insert Toy values(?, ?, ?, ?, ?)");
        //provide values for cac tham so
        stm.setString(1, toy.getId());
        stm.setString(2, toy.getName());
        stm.setDouble(3, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(toy.getExpDate()));
        stm.setString(5, toy.getBrand());
        //execute sql command
        int count = stm.executeUpdate();
        //close connection to db
        con.close();
    }
    
    public void delete(String id) throws SQLException {
        //create connection to db
        Connection con = DBContext.getConnection();
        //create object stm and execute select command
        PreparedStatement stm = con.prepareStatement("delete Toy where id = ?");
        //provide values for cac tham so
        stm.setString(1, id);
        //execute sql command
        int count = stm.executeUpdate();
        //close connection to db
        con.close();
    }
    
    public Toy read(String id) throws SQLException {
        Toy toy = null;
        //create connection to db
        Connection con = DBContext.getConnection();
        //create object stm and execute select command
        PreparedStatement stm = con.prepareStatement("select * from Toy where id = ?");
        //provide values for cac tham so
        stm.setString(1, id);
        //execute sql command
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            //read(add) current row to object toy
            toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getInt("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrand(rs.getString("brand"));        
        }
        //close connection to db
        con.close();
        return toy;
    }
    
    public void update(Toy toy) throws SQLException {
        //create connection to db
        Connection con = DBContext.getConnection();
        //create object stm and execute select command
        PreparedStatement stm = con.prepareStatement("update Toy set Name=?, Price=?, expDate=?, Brand=? where id=?");
        //provide values for cac tham so   
        stm.setString(1, toy.getName());
        stm.setDouble(2, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(toy.getExpDate()));
        stm.setString(4, toy.getBrand());
        stm.setString(5, toy.getId());
        //execute sql command
        int count = stm.executeUpdate();
        //close connection to db
        con.close();
    }
    
}
