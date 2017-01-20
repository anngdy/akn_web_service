package dao;

import controller.Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ContactReason;

/**
 *
 * @author nabts
 */
public class ContactReasonDAO {
    private PreparedStatement pst;
    private ResultSet res;
    private Connection con;
    
    private String sql;
    
    public List<ContactReason> getContactReasons() throws ClassNotFoundException, SQLException{
        List<ContactReason> c_reason = new ArrayList<ContactReason>();
        ContactReason new_c_reason = null;
        sql = "SELECT * FROM contact_reason";
        con = Controller.conection();
        pst = con.prepareStatement(sql);
        res = pst.executeQuery();
         while(res.next()){
             new_c_reason = new ContactReason();
             new_c_reason.setId(res.getInt("id"));
             new_c_reason.setContent(res.getString("content"));
             
             c_reason.add(new_c_reason);
         }
         Controller.desconection();
         return c_reason;       
    }
    
    public boolean insertContactReasons(ContactReason c_reason){
        try {
            sql = "INSERT INTO contact_reason(id, content) VALUES (?,?)";
            con = Controller.conection();
            pst = con.prepareStatement(sql);
            pst.setInt(1,c_reason.getId());
            pst.setString(2, c_reason.getContent());
            pst.execute();
            Controller.desconection();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ContactReasonDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
