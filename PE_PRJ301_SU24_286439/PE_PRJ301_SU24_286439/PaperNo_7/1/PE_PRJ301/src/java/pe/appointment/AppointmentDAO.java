package pe.appointment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

public class AppointmentDAO {
    //your code here
    public List<AppointmentDTO> select() throws ClassNotFoundException, SQLException {
        List<AppointmentDTO> list = null;
        Connection con = DBUtils.getConnection();
        Statement stm = con.createStatement();        
        ResultSet rs = stm.executeQuery("Select * from Appointments");
        list = new ArrayList();
        
        while (rs.next()) {
            AppointmentDTO app = new AppointmentDTO();
            app.setIdApp(rs.getInt("idApp"));
            app.setAccount(rs.getString("account"));
            app.setPartnerPhone(rs.getString("partnerPhone"));
            app.setPartnerName(rs.getString("partnerName"));
            app.setTimeToMeet(rs.getDate("timeToMeet"));
            app.setPlace(rs.getString("place"));
            app.setExpense(rs.getDouble("expense"));
            app.setNote(rs.getString("note"));
            list.add(app);
        }
        con.close();
        return list;
    }
    public void create(String account, String partnerPhone, String partnerName, Date timeToMeet, String place, double expense, String note) throws ClassNotFoundException, SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT Appointments(account, partnerPhone, partnerName, timeToMeet, place, expense, note) VALUES(?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, account);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(2, partnerPhone);
        stm.setString(3, partnerName);
        stm.setString(4,sdf.format(timeToMeet));
        stm.setString(5, place);
        stm.setDouble(6, expense);
        stm.setString(7, note);
        int count = stm.executeUpdate();
        con.close();
    }
}
