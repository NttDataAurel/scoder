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

import com.nttdata.practicadevara.scoder.shared.dto.UserSkillDto;
import com.nttdata.practicadevara.scoder.ejb.UserSkillBean;
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
 * REST Web Service
 */
@Path("/userskill")
@Stateless
@LocalBean
public class ServicesUserSkill {
/* Not Used Anymore
    @EJB 
    private UserSkillBean userSkillEjb;
    
    @Context
    private UriInfo context;


    public ServicesUserSkill() {
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserSkillValues() {
        List<UserSkillDto> userSkills = userSkillEjb.list();
        return Response.ok(userSkills).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserSkillValuesById(@PathParam("id") Long id,
                                        @Context HttpServletRequest servletRequest) {
        UserSkillDto userSkill = userSkillEjb.findById(id);
        return Response.ok(userSkill).build();
    }
    
    @GET
    @Path("/searchByUserId")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserSkillValuesByUserId(@DefaultValue("") @QueryParam("filterByUserId") Long userId,
                                        @Context HttpServletRequest servletRequest) {
        
        List<UserSkillDto> userSkills = userSkillEjb.filterByUserId(userId);
        return Response.ok(userSkills).build();
    }

    @GET
    @Path("/searchByPhaseId")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserSkillValuesByPhaseId(@DefaultValue("") @QueryParam("filterByPhaseId") Long phaseId,
                                        @Context HttpServletRequest servletRequest) {
        List<UserSkillDto> userSkills = userSkillEjb.filterByPhaseId(phaseId);
        return Response.ok(userSkills).build();
    }

    @GET
    @Path("/searchByName")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterUserSkillValuesByName(@DefaultValue("") @QueryParam("filterByName") String filterByNameTxt,
                                        @Context HttpServletRequest servletRequest) {
        List<UserSkillDto> userSkills = userSkillEjb.filterByName(filterByNameTxt);
        return Response.ok(userSkills).build();
    }

    @PUT
    //@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUserSkill(UserSkillDto userSkill) {
        UserSkillDto res = userSkillEjb.create(userSkill);
        return Response.ok(res).build();
    }
    
    @POST
    //@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserSkillDto updateUserSkill(UserSkillDto userSkill) throws BackendException{
        try{
            return userSkillEjb.update(userSkill);
        }catch(DBException ex){
            throw new BackendException(ex.getMessage());
        }
    }
    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUserSkill(@DefaultValue("") @QueryParam("id")  Long id) throws DBException {
        userSkillEjb.deleteUserSkill(id);
    }
  */
}