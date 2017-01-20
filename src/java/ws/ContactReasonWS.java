/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.ContactReasonDAO;
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
import model.ContactReason;

/**
 * REST Web Service
 *
 * @author nabts
 */
@Path("contact_reason")
public class ContactReasonWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContactReasonWS
     */
    public ContactReasonWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ContactReasonWS
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
    @Path ("get/contact_reason")
    public String getContactReason() throws SQLException, ClassNotFoundException{
        Gson gson_obj = new Gson ();
        ContactReasonDAO dao = new ContactReasonDAO();
        List<ContactReason> c_reason = dao.getContactReasons();
        return gson_obj.toJson(c_reason);        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add_contact_reason")
    public boolean insertContactReason(String content){
        Gson gson_obj = new Gson();
        ContactReason c_reason = (ContactReason)gson_obj.fromJson(content, ContactReason.class);
        ContactReasonDAO dao = new ContactReasonDAO();
        return dao.insertContactReasons(c_reason);
    }

    /**
     * PUT method for updating or creating an instance of ContactReasonWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
