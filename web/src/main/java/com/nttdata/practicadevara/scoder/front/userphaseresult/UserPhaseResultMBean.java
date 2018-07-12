package com.nttdata.practicadevara.scoder.front.userphaseresult;

import com.nttdata.practicadevara.scoder.shared.dto.UserPhaseResultDto;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("userPhaseReultMBean")
public class UserPhaseResultMBean {
    
    @EJB
    private UserPhaseResultRest restClient;
    
    public UserPhaseResultMBean() {
    }
    
    public List<UserPhaseResultDto> getUserPhaseResult(){
        List<UserPhaseResultDto> list = restClient.listUserPhaseResult();
        return list;
    }
    
}
