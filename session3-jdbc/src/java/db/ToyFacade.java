

package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
}
