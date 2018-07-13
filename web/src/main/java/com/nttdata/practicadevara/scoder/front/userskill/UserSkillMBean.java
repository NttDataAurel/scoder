package com.nttdata.practicadevara.scoder.front.userskill;

import com.nttdata.practicadevara.scoder.shared.dto.UserSkillDto;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("userSkillMBean")
public class UserSkillMBean {
    
    @EJB
    private UserSkillRest restClient;

    /**
     * Creates a new instance of UserSkillMBean
     */
    public UserSkillMBean() {
    }
    
    public List<UserSkillDto> getUserSkills(){
        List<UserSkillDto> list = restClient.listUserSkill();
        return list;
    }
    
}
