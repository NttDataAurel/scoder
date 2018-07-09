package com.nttdata.practicadevara.scoder.front;

import com.nttdata.practicadevara.scoder.shared.dto.AppConfigDto;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:ServicesAppConfig [/]<br>
 * USAGE:
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 */

public class RestClient {

    private final javax.ws.rs.client.WebTarget webTarget;
    private final javax.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:2080/scoderServices";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }

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

    public List<AppConfigDto> listAppConfig() throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        Response resp = resource.path("appconfiglist").request(MediaType.APPLICATION_JSON).get(Response.class);
        List<AppConfigDto> ret = resp.readEntity(new GenericType<List<AppConfigDto>>(){});
        return ret;
    }

    public void close() {
        client.close();
    }
    
}
