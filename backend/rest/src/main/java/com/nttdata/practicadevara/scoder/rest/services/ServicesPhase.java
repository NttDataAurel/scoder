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

import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import com.nttdata.practicadevara.scoder.ejb.PhaseBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 */
@Path("/phase")
@Stateless
public class ServicesPhase {

    @EJB 
    private PhaseBean phaseEjb;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesPhase() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPhaseValues() {
        List<PhaseDto> phases = phaseEjb.list();
        return Response.ok(phases).build();
    }
    
    @GET
    @Path("/namesearch")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterNamePhaseValues(@DefaultValue("") @QueryParam("filterName") String filterTxt,
                                        @Context HttpServletRequest servletRequest) {
        List<PhaseDto> phasesName = phaseEjb.filterName(filterTxt);
        return Response.ok(phasesName).build();
    }
    
    @GET
    @Path("/prioritysearch")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterPriorityPhaseValues(@DefaultValue("") @QueryParam("filterPriority") Integer filterPriority,
                                        @Context HttpServletRequest servletRequest) {
        List<PhaseDto> phasesPriority = phaseEjb.filterPriority(filterPriority);
        return Response.ok(phasesPriority).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPhase(PhaseDto phase) {
        phaseEjb.createPhase(phase);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePhase(PhaseDto phase) throws DBException {
        phaseEjb.updatePhase(phase);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePhase(@DefaultValue("") @QueryParam("id")  Long id) throws DBException {
        phaseEjb.deletePhase(id);
    }
}

