package com.nttdata.practicadevara.scoder.rest.services;

import com.nttdata.practicadevara.scoder.db.DBException;
import com.nttdata.practicadevara.scoder.ejb.UserBean;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import javax.ejb.EJB;
import java.util.List;
import javax.ws.rs.core.Response;

import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import com.nttdata.practicadevara.scoder.shared.exception.BackendException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service for user
 */
@Path("/user")
@Stateless
@LocalBean
public class ServicesUser {

    @EJB
    private UserBean userEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesUser() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserValues() {
        List<UserDto> Users = userEjb.list();
        return Response.ok(Users).build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterByNameAndAddress(@DefaultValue("") @QueryParam("name") String name,
            @DefaultValue("") @QueryParam("address") String address,
            @Context HttpServletRequest servletRequest) {
        List<UserDto> users = userEjb.filterByNameAndAddress(name, address);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id,
            @Context HttpServletRequest servletRequest) {
        UserDto User = userEjb.findById(id);
        return Response.ok(User).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(UserDto User) {
        UserDto res = userEjb.create(User);
        return Response.ok(res).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDto updateUser(UserDto User) throws BackendException {
        try {
            return userEjb.update(User);
        } catch (DBException ex) {
            throw new BackendException(ex.getMessage());
        }
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@DefaultValue("") @QueryParam("id")  Long id) throws DBException {
        userEjb.delete(id);
    }
    
    
    @DELETE
    @Path("userskill/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUserSkill(@DefaultValue("") @QueryParam("id")  Long id) throws DBException {
        userEjb.deleteUserSkill(id);
    }
    
}
