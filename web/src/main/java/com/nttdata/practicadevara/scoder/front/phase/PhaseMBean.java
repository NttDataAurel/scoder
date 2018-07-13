package com.nttdata.practicadevara.scoder.front.phase;

import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("phaseMBean")
public class PhaseMBean {
    
    @EJB
    private PhaseRest restClient;

    /**
     * Creates a new instance of PhaseMBean
     */
    public PhaseMBean() {
    }
    
    public List<PhaseDto> getPhases(){
        List<PhaseDto> list = restClient.listPhase();
        return list;
    }
    
}
