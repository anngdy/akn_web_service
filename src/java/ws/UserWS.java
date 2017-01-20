/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.UserDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.User;

/**
 * REST Web Service
 *
 * @author nabts
 */
@Path("user")
public class UserWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserWS
     */
    public UserWS() {
    }

    /**
     * Retrieves representation of an instance of ws.UserWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path ("get/users")
    public String getUsers() throws SQLException, ClassNotFoundException{
        Gson gson_obj = new Gson ();
        UserDAO dao = new UserDAO();
        List<User> user = dao.getUsers();
        
        return gson_obj.toJson(user);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add_user")
    public boolean insertUsers(String content){
        Gson gson_obj = new Gson ();
        User user = (User)gson_obj.fromJson(content, User.class);
        UserDAO dao = new UserDAO();
        return dao.insertUsers(user);
    }    
    
    /**
     * PUT method for updating or creating an instance of UserWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
