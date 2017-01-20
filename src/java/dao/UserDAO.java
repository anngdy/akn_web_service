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
import model.User;

/**
 *
 * @author nabts
 */
public class UserDAO {
    private PreparedStatement pst;
    private ResultSet res;
    private Connection con;
    
    private String sql;
    
    public List<User> getUsers() throws ClassNotFoundException, SQLException{
        List<User> user = new ArrayList<User>();
        User new_user = null;
        sql = "SELECT * FROM user";
        con = Controller.conection();
        pst = con.prepareStatement(sql);
        res = pst.executeQuery();
        while(res.next()){
            new_user = new User();
            new_user.setId(res.getInt("id"));
            new_user.setName(res.getString("name"));
            new_user.setCpf(res.getString("cpf"));
            new_user.setEmail(res.getString("email"));
            
            user.add(new_user);
        }
            Controller.desconection();
            return user;
    }
    
    public boolean insertUsers(User user){
        try {
            sql = "INSERT INTO user (id, name, email, cpf) values (?,?,?,?)";
            con = Controller.conection();
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getCpf());
            pst.execute();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        
    }
    
}
