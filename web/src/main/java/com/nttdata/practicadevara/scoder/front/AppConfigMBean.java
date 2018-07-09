package com.nttdata.practicadevara.scoder.front;

import com.nttdata.practicadevara.scoder.shared.dto.AppConfigDto;
import java.util.List;
import java.util.Arrays;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Dependent
@Named("appConfigMBean")
public class AppConfigMBean {
    
    private RestClient restClient = new RestClient();

    /**
     * Creates a new instance of AppConfigMBean
     */
    public AppConfigMBean() {
    }
    
    public List<AppConfigDto> getAppConfigs(){
        System.out.println("getAppConfigs. ");
        List<AppConfigDto> list = restClient.listAppConfig();
        if(list == null || list.isEmpty()) list = Arrays.asList(new AppConfigDto(1L, "a", "aa"),  new AppConfigDto(2L, "b", "bb"));
        return list;
    }
    
}
