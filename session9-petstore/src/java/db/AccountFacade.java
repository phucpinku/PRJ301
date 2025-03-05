

package db;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Hasher;


public class AccountFacade {
    
    public Account login(String email, String password) throws SQLException, NoSuchAlgorithmException{
        Account account = null;
        //tạo kết nối db
        Connection con = DBContext.getConnection();
        //tạo đối tượng stm và thực hiện lệnh select
        PreparedStatement stm = con.prepareStatement("select * from Account where email = ? and password=? ");
        //cung cấp giá trị cho các tham số
        stm.setString(1, email);
        stm.setString(2, Hasher.hash(password));
        //thực hiện lệnh sql
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            //đọc dòng hiện hành vào đối tượng account
            account = new Account();
            account.setId(rs.getInt("id"));
            account.setEmail(rs.getString("email"));
            account.setPassword(rs.getString("password"));
            account.setFullName(rs.getString("fullName"));
            account.setRole(rs.getString("role"));
        }      
        //đóng kết nối db
        con.close();
        return account;
    }
    
}
