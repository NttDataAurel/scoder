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
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 */
@Path("/user")
@Stateless
@LocalBean
public class ServicesUser {

    @EJB 
    private UserBean UserEjb;
    
    @Context
    private UriInfo context;
    
    
    /**
     * Creates a new instance of WebServices
     */
    public ServicesUser() {
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserValues() {
        List<UserDto> Users = UserEjb.list();
        return Response.ok(Users).build();
    }
    
    @GET
    @Path("/filterbynameandadress")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterByNameAndAddress(@DefaultValue("false") @QueryParam("name") String name,
                                         @DefaultValue("false") @QueryParam("addr") String address,
                                         @Context HttpServletRequest servletRequest) {
        List<UserDto> users = UserEjb.filterByNameAndAddress(name, address);
        return Response.ok(users).build();
    }

    @GET
    @Path("/filterbynameorsurname")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterByNameOrSurname(@DefaultValue("false") @QueryParam("name") String name,
                                         @DefaultValue("false") @QueryParam("surname") String surname,
                                         @Context HttpServletRequest servletRequest) {
        List<UserDto> User = UserEjb.filterByNameOrSurname(name, surname);
        return Response.ok(User).build();
    }
       
    @GET
    @Path("/findbyid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findById(@DefaultValue("0") @QueryParam("findById") Long id,
                                       @Context HttpServletRequest servletRequest) {       
        UserDto User = UserEjb.findById(id);
        return Response.ok(User).build();
    }
    
    @PUT
    //@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(UserDto User) {
        UserDto res = UserEjb.create(User);
        return Response.ok(res).build();
    }
    
    @POST
    //@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDto updateUser(UserDto User) throws BackendException{
        try{
            return UserEjb.update(User);
        }catch(DBException ex){
            throw new BackendException(ex.getMessage());
        }
    }
}
