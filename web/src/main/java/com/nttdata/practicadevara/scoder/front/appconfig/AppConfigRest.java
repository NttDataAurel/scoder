package com.nttdata.practicadevara.scoder.front.appconfig;

import com.nttdata.practicadevara.scoder.front.RestClient;
import com.nttdata.practicadevara.scoder.shared.dto.AppConfigDto;
import com.nttdata.practicadevara.scoder.shared.exception.BackendException;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ClientErrorException;

@Stateless
@LocalBean
public class AppConfigRest extends RestClient {
    
    
//    public <T> T updateAppConfig(Object requestEntity, Class<T> responseType) throws javax.ws.rs.ClientErrorException {
//        return webTarget.path("appconfig").request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), responseType);
//    }
//
//    public <T> T filterAppConfigValues(Class<T> responseType, String id) throws javax.ws.rs.ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path(java.text.MessageFormat.format("appconfig/{0}", new Object[]{id}));
//        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public Response newAppConfig(Object requestEntity) throws javax.ws.rs.ClientErrorException {
//        return webTarget.path("appconfig").request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
//    }

    public List<AppConfigDto> listAppConfig() throws ClientErrorException {
        Response resp = super.path("appconfiglist").request(MediaType.APPLICATION_JSON).get(Response.class);
        List<AppConfigDto> ret = resp.readEntity(new GenericType<List<AppConfigDto>>(){});
        return ret;
    }
    
    public List<AppConfigDto> filterAppConfig(String text) throws ClientErrorException {
        Response resp = super.path("appconfigsearch")
                .queryParam("filter", text)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
        return resp.readEntity(new GenericType<List<AppConfigDto>>(){});
    }
    
    public AppConfigDto update(AppConfigDto entry) throws ClientErrorException, BackendException {
        Response resp = super.path("appconfig").request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        AppConfigDto ret = resp.readEntity(AppConfigDto.class);
        return ret;
    }
    
    public AppConfigDto create(AppConfigDto entry) throws ClientErrorException, BackendException {
        Response resp = super.path("appconfig").request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        AppConfigDto ret = resp.readEntity(AppConfigDto.class);
        return ret;
    }
}
