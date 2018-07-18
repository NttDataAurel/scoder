package com.nttdata.practicadevara.scoder.front.user;

import com.nttdata.practicadevara.scoder.front.RestClient;
import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import com.nttdata.practicadevara.scoder.shared.exception.BackendException;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class UserRest extends RestClient {

    public List<UserDto> listUser() throws javax.ws.rs.ClientErrorException {
        Response resp = super.path("user").request(MediaType.APPLICATION_JSON).get(Response.class);
        List<UserDto> ret = resp.readEntity(new GenericType<List<UserDto>>() {
        });
        return ret;
    }

    public List<UserDto> filterUser(String name, String address) throws ClientErrorException {
        Response resp = super.path("user/search")
                .queryParam("name", name)
                .queryParam("address", address)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
        return resp.readEntity(new GenericType<List<UserDto>>() {
        });
    }

    public UserDto update(UserDto entry) throws ClientErrorException, BackendException {
        Response resp = super.path("user").request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        UserDto ret = resp.readEntity(UserDto.class);
        return ret;
    }

    public UserDto create(UserDto entry) throws ClientErrorException, BackendException {
        Response resp = super.path("user").request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        UserDto ret = resp.readEntity(UserDto.class);
        return ret;
    }
    
    public void delete(UserDto entry) throws javax.ws.rs.ClientErrorException{
        super.path("user").queryParam("id", entry.getId()).request(MediaType.APPLICATION_JSON).delete(Response.class);
    }
}
