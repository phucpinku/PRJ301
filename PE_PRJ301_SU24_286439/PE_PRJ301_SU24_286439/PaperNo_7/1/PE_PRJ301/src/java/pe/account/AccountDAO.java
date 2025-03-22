package pe.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

public class AccountDAO {
    //your code here
    public List<AccountDTO> select() throws ClassNotFoundException, SQLException {
        List<AccountDTO> list = null;
        Connection con = DBUtils.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Account");
        
        list = new ArrayList<>();
        
        while (rs.next()) {
            AccountDTO acc = new AccountDTO();
            acc.setAccount(rs.getString("account"));
            acc.setPass(rs.getString("pass"));
            acc.setRoleDB(rs.getString("roleDB"));
            acc.setFullName(rs.getString("fullName"));
            acc.setGender(rs.getBoolean("gender"));
            acc.setBirthDay(rs.getDate("birthDay"));
            acc.setPhone(rs.getString("phone"));
            acc.setAddr(rs.getString("addr"));
            
            list.add(acc);
        }
        con.close();
        return list;
    }
    
    public AccountDTO login(String account, String pass) throws ClassNotFoundException, SQLException {
        AccountDTO acc = null;
        Connection con = DBUtils.getConnection();
        
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Account WHERE account = ? AND pass = ?");
        stm.setString(1, account);
        stm.setString(2, pass);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            acc = new AccountDTO();
            acc.setAccount(rs.getString("account"));
            acc.setPass(rs.getString("pass"));
            acc.setRoleDB(rs.getString("roleDB"));
            acc.setFullName(rs.getString("fullName"));
            acc.setGender(rs.getBoolean("gender"));
            acc.setBirthDay(rs.getDate("birthDay"));
            acc.setPhone(rs.getString("phone"));
            acc.setAddr(rs.getString("addr"));
            
        }
        con.close();
        return acc;
    }
}
