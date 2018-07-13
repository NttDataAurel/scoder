package com.nttdata.practicadevara.scoder.front.user;

import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("userMBean")
public class UserMBean {
    
    @EJB
    private UserRest restClient;

    /**
     * Creates a new instance of AppConfigMBean
     */
    public UserMBean() {
    }
    
 public List<UserDto> getUsers(){
        List<UserDto> list = restClient.listUser();
        return list;
    }
   
    
}
