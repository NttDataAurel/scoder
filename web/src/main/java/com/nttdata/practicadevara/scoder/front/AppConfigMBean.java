package com.nttdata.practicadevara.scoder.front;

import com.nttdata.practicadevara.scoder.shared.dto.AppConfigDto;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("appConfigMBean")
public class AppConfigMBean {
    
    private RestClient restClient = new RestClient();

    /**
     * Creates a new instance of AppConfigMBean
     */
    public AppConfigMBean() {
    }
    
    public List<AppConfigDto> getAppConfigs(){
        List<AppConfigDto> list = restClient.listAppConfig();
        return list;
    }
    
}
