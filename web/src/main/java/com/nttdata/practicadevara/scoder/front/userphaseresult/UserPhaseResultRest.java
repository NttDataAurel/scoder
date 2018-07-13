package com.nttdata.practicadevara.scoder.front.userphaseresult;

import com.nttdata.practicadevara.scoder.front.RestClient;
import com.nttdata.practicadevara.scoder.shared.dto.UserPhaseResultDto;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class UserPhaseResultRest extends RestClient {
    
    
    public <T> T updateUserPhaseResult(Object requestEntity, Class<T> responseType) throws javax.ws.rs.ClientErrorException {
        return super.getBaseWebTarget().path("userphaseresult").request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T filterUserPhaseResultByDate(Class<T> responseType, String date) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = getBaseWebTarget();
        resource = resource.path("/userphaseresult/searchByDate").queryParam("filterByDate", date); 
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T filterUserPhaseResultByUserId(Class<T> responseType, long userId) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = getBaseWebTarget();
        resource = resource.path("/userphaseresult/searchByUserId").queryParam("filterByUserId", userId); 
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T filterUserPhaseResultByPhaseId(Class<T> responseType, long phaseId) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = getBaseWebTarget();
        resource = resource.path("/userphaseresult/searchByPhaseId").queryParam("filterByPhaseId", phaseId); 
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T filterUserPhaseResultByRank(Class<T> responseType, double rank) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = getBaseWebTarget();
        resource = resource.path("/userphaseresult/searchUserByRank").queryParam("filterByRank", rank); 
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T filterUserPhaseResultByPassed(Class<T> responseType, boolean passed) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = getBaseWebTarget();
        resource = resource.path("/userphaseresult/searchUserByPassed").queryParam("filterByPassed", passed); 
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public Response newUserPhaseResult(Object requestEntity) throws javax.ws.rs.ClientErrorException {
        return getBaseWebTarget().path("/userphaseresult").request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public List<UserPhaseResultDto> listUserPhaseResult() throws javax.ws.rs.ClientErrorException {
        Response resp = super.path("/userphaseresult/UserPhaseResultList").request(MediaType.APPLICATION_JSON).get(Response.class);
        List<UserPhaseResultDto> ret = resp.readEntity(new GenericType<List<UserPhaseResultDto>>(){});
        return ret;
    }

}
