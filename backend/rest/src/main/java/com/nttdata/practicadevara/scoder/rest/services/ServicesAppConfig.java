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

import com.nttdata.practicadevara.scoder.shared.dto.AppConfigDto;
import com.nttdata.practicadevara.scoder.ejb.AppConfigBean;
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
@Path("/appconfig")
@Stateless
@LocalBean
public class ServicesAppConfig {

    @EJB
    private AppConfigBean appConfigEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesAppConfig() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAppConfigValues() {
        List<AppConfigDto> appConfigs = appConfigEjb.list();
        return Response.ok(appConfigs).build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterAppConfigValues(@DefaultValue("") @QueryParam("filter") String filterTxt,
            @Context HttpServletRequest servletRequest) {
        List<AppConfigDto> appConfigs = appConfigEjb.filter(filterTxt);
        return Response.ok(appConfigs).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterAppConfigValues(@PathParam("id") Long id,
            @Context HttpServletRequest servletRequest) {
        AppConfigDto appConfig = appConfigEjb.findById(id);
        return Response.ok(appConfig).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newAppConfig(AppConfigDto appConfig) {
        AppConfigDto res = appConfigEjb.create(appConfig);
        return Response.ok(res).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AppConfigDto updateAppConfig(AppConfigDto appConfig) throws BackendException {
        try {
            return appConfigEjb.update(appConfig);
        } catch (DBException ex) {
            throw new BackendException(ex.getMessage());
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAppConfig(@DefaultValue("") @QueryParam("id") Long id) throws BackendException {
        try {
            appConfigEjb.delete(id);
        } catch (DBException ex) {
            throw new BackendException(ex.getMessage());
        }
    }
}
