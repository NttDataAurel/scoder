package com.nttdata.practicadevara.scoder.front.user;

import com.nttdata.practicadevara.scoder.front.RestClient;
import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class UserRest extends RestClient {
    
    
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
    public List<UserDto> listUser() throws javax.ws.rs.ClientErrorException {
        Response resp = super.path("user/list").request(MediaType.APPLICATION_JSON).get(Response.class);
        List<UserDto> ret = resp.readEntity(new GenericType<List<UserDto>>(){});
        return ret;
    }
    
    }

    

