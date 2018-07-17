package com.nttdata.practicadevara.scoder.front.userskill;

import com.nttdata.practicadevara.scoder.front.RestClient;
import com.nttdata.practicadevara.scoder.shared.dto.UserSkillDto;
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
public class UserSkillRest extends RestClient {
    
    
//    public <T> T updateUserSkill(Object requestEntity, Class<T> responseType) throws javax.ws.rs.ClientErrorException {
//        return webTarget.path("appconfig").request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), responseType);
//    }
//
//    public <T> T filterUserSkillValues(Class<T> responseType, String id) throws javax.ws.rs.ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path(java.text.MessageFormat.format("appconfig/{0}", new Object[]{id}));
//        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public Response newUserSkill(Object requestEntity) throws javax.ws.rs.ClientErrorException {
//        return webTarget.path("appconfig").request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
//    }

    public List<UserSkillDto> listUserSkill() throws javax.ws.rs.ClientErrorException {
        Response resp = super.path("userskill/list").request(MediaType.APPLICATION_JSON).get(Response.class);
        List<UserSkillDto> ret = resp.readEntity(new GenericType<List<UserSkillDto>>(){});
        return ret;
    }

    public List<UserSkillDto> filterByNameUserSkill(String filterByNameTxt) throws ClientErrorException {
        Response resp = super.path("userskill/searchByName")
                .queryParam("filterByName", filterByNameTxt)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
        return resp.readEntity(new GenericType<List<UserSkillDto>>(){});
    }
    
    public UserSkillDto update(UserSkillDto entry) throws ClientErrorException, BackendException {
        Response resp = super.path("userskill").request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        UserSkillDto ret = resp.readEntity(UserSkillDto.class);
        return ret;
    }
    
    public UserSkillDto create(UserSkillDto entry) throws ClientErrorException, BackendException {
        Response resp = super.path("userskill").request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        UserSkillDto ret = resp.readEntity(UserSkillDto.class);
        return ret;
    }
    
    public void deleteUserSkill(UserSkillDto entry) throws ClientErrorException, BackendException{
        super.path("userskill/delete").queryParam("id", entry.getId()).request(MediaType.APPLICATION_JSON).delete(Response.class);
    }
}
