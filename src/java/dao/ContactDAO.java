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
import model.Contact;
import model.ContactReason;

/**
 *
 * @author nabts
 */
public class ContactDAO {
    private PreparedStatement pst;
    private ResultSet res;
    private Connection con;
    
    private String sql;
    
    public List<Contact> getContacts() throws SQLException, ClassNotFoundException {
        List<Contact> contact = new ArrayList<Contact>();
        Contact new_contact = null;
        sql = "SELECT * FROM contact";
        con = Controller.conection();
        pst = con.prepareStatement(sql);
        res = pst.executeQuery();
        while(res.next()){
            new_contact = new Contact();
            new_contact.setId(res.getInt("id"));
            new_contact.setName(res.getString("nome"));
            new_contact.setCpf(res.getString("cpf"));
            new_contact.setMessage(res.getString("message"));
            new_contact.setNew_date(res.getDate("date"));
            new_contact.setEmail(res.getString("email"));
            
            contact.add(new_contact);            
        }
        Controller.desconection();
        return contact;       
    }
    
    public boolean insertContact(Contact contact){
        try {
            sql = "INSERT INTO contact(id, contact_reason_id, user_id, message, new_date) VALUES (?,?,?,?,?)";
            con = Controller.conection();
            pst = con.prepareStatement(sql);
            pst.setInt(1,contact.getId());
            //pst.setString(2, contact.());
            pst.setString(3,contact.getName());
            pst.setString(4, contact.getCpf());
            pst.setString(5, contact.getEmail());
            pst.setDate(6, contact.getNew_date());
            pst.execute();
            Controller.desconection();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
