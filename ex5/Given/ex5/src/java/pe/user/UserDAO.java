/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;


/**
 *
 * @author Hoadnt
 */
public class UserDAO {
//    your code here
    public List<UserDTO> select() throws SQLException, ClassNotFoundException {
        List<UserDTO> list = null;

        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM tblUsers");

        list = new ArrayList<>();

        while (rs.next()) {
            UserDTO user = new UserDTO();
            user.setUserID(rs.getString("userID"));
            user.setFullName(rs.getString("fullName"));
            user.setRoleID(rs.getString("roleID"));
            
            list.add(user);
        }

        con.close();
        return list;
    }

    public UserDTO login(String userID, String password) throws SQLException, ClassNotFoundException {
        UserDTO user = null;
        
        Connection con = DBUtils.getConnection();
        
        PreparedStatement stm = con.prepareStatement("SELECT * FROM tblUsers WHERE userID = ? AND password = ? ");
        
        stm.setString(1, userID);
        stm.setString(2, password);
        
        ResultSet rs = stm.executeQuery();
        
        if(rs.next()) {
            user = new UserDTO();
            user.setUserID(rs.getString("userID"));
            user.setFullName(rs.getString("fullName"));
            user.setRoleID(rs.getString("roleID"));
            user.setPassword(rs.getString("password"));
        }
        
        con.close();
        return user;
    }
    
    
}
