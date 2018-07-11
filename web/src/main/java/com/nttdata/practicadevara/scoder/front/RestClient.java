package com.nttdata.practicadevara.scoder.front;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

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
    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:2080/scoderServices";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    public void close() {
        client.close();
    }
    
    public WebTarget getBaseWebTarget(){
        return webTarget;
    }
    
    public WebTarget path(String path){
        return webTarget.path(path);
    }
}
