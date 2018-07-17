package com.nttdata.practicadevara.scoder.front.phase;

import com.nttdata.practicadevara.scoder.front.RestClient;
import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class PhaseRest extends RestClient {

    public List<PhaseDto> listPhase() throws javax.ws.rs.ClientErrorException {
        Response resp = super.path("phase").request(MediaType.APPLICATION_JSON).get(Response.class);
        List<PhaseDto> ret = resp.readEntity(new GenericType<List<PhaseDto>>(){});
        return ret;
    }
    
    public void createPhase(PhaseDto phase) throws javax.ws.rs.ClientErrorException {
        Response resp=super.path("phase").request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(phase, MediaType.APPLICATION_JSON), Response.class);
        List<PhaseDto> ret = resp.readEntity(new GenericType<List<PhaseDto>>(){});
    }

    public PhaseDto updatePhase(PhaseDto entry) throws javax.ws.rs.ClientErrorException{
        Response resp = super.path("phase").request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        PhaseDto ret = resp.readEntity(PhaseDto.class);
        return ret;
    }
    
    public void deletePhase(PhaseDto entry) throws javax.ws.rs.ClientErrorException{
        super.path("phase").queryParam("id", entry.getId()).request(MediaType.APPLICATION_JSON).delete(Response.class);
    }
}
