package controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nabts
 */

public class Controller {
    private static final String DB_URL = "jdbc:mysql://localhost/akn_project";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "MyNewPass";   
    
    private static Connection con;
    
    public static Connection conection() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        return con;
    }
    
    public static void desconection (){
        try{  
            con.close();
        } catch(SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
