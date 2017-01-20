/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.ContactDAO;
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
import model.Contact;

/**
 * REST Web Service
 *
 * @author nabts
 */
@Path("Contact")
public class ContactWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContactWS
     */
    public ContactWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ContactWS
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
    @Path ("get/contact")
    public String getContact() throws SQLException, ClassNotFoundException{
        Gson gson_obj = new Gson ();
        ContactDAO dao = new ContactDAO();
        List<Contact> contact = dao.getContacts();
        
        return gson_obj.toJson(contact);        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add_contact")
    public boolean insertContact(String content){
        Gson gson_obj = new Gson();
        Contact contact = (Contact)gson_obj.fromJson(content, Contact.class);
        ContactDAO dao = new ContactDAO();
        return dao.insertContact(contact);
    }
    

    /**
     * PUT method for updating or creating an instance of ContactWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
   
    
}
