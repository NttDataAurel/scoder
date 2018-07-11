package com.nttdata.practicadevara.scoder.rest.services;

import com.nttdata.practicadevara.scoder.db.DBException;
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

import com.nttdata.practicadevara.scoder.shared.dto.UserPhaseResultDto;
import com.nttdata.practicadevara.scoder.ejb.UserPhaseResultBean;
import com.nttdata.practicadevara.scoder.shared.exception.BackendException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 */
@Path("/userphaseresult")
@Stateless
@LocalBean
public class ServicesUserPhaseResult {

    @EJB 
    private UserPhaseResultBean userPhaseResultEjb;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesUserPhaseResult() {
    }

    @GET
    @Path("/UserPhaseResultList")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserPhaseResultValues() {
        List<UserPhaseResultDto> userPhaseResult = userPhaseResultEjb.list();
        return Response.ok(userPhaseResult).build();
    }
    
    @GET
    @Path("/searchByDate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserPhaseResultValuesByDate(@DefaultValue("") @QueryParam("filterByDate") String date,
                                        @Context HttpServletRequest servletRequest) {
        List<UserPhaseResultDto> userPhaseResult = userPhaseResultEjb.findByDate(date);
        return Response.ok(userPhaseResult).build();
    }
    
    @GET
    @Path("/searchByUserId")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserPhaseResultValuesByUserId(@DefaultValue("") @QueryParam("filterByUserId") Long userId,
                                        @Context HttpServletRequest servletRequest) {
        List<UserPhaseResultDto> userPhaseResult = userPhaseResultEjb.findByUserId(userId);
        return Response.ok(userPhaseResult).build();
    }
    
    @GET
    @Path("/searchByPhaseId")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserPhaseResultValuesByPhaseId(@DefaultValue("") @QueryParam("filterByPhaseId") Long phaseId,
                                        @Context HttpServletRequest servletRequest) {
        List<UserPhaseResultDto> userPhaseResult = userPhaseResultEjb.findByPhaseId(phaseId);
        return Response.ok(userPhaseResult).build();
    }
    
    @GET
    @Path("/searchUserByRank")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserPhaseResultValuesByRank(@DefaultValue("") @QueryParam("filterByRank") double rank,
                                        @Context HttpServletRequest servletRequest) {
        List<UserPhaseResultDto> userPhaseResult = userPhaseResultEjb.findByRank(rank);
        return Response.ok(userPhaseResult).build();
    }
    
    @GET
    @Path("/searchUserByPassed")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserPhaseResultValuesByPassed(@DefaultValue("") @QueryParam("filterByPassed") boolean passed,
                                        @Context HttpServletRequest servletRequest) {
        List<UserPhaseResultDto> userPhaseResult = userPhaseResultEjb.findByPassed(passed);
        return Response.ok(userPhaseResult).build();
    }
    
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUserPhaseResult(UserPhaseResultDto userPhaseResult) {
        UserPhaseResultDto res = userPhaseResultEjb.create(userPhaseResult);
        return Response.ok(res).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserPhaseResultDto updateUserPhaseResult(UserPhaseResultDto userPhaseResult) throws BackendException{
        try{
            return userPhaseResultEjb.update(userPhaseResult);
        }catch(DBException ex){
            throw new BackendException(ex.getMessage());
        }
    }
}
