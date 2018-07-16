package com.nttdata.practicadevara.scoder.front.appconfig;

import com.nttdata.practicadevara.scoder.shared.dto.AppConfigDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("appConfigMBean")
public class AppConfigMBean implements Serializable{
    
    private static final long serialVersionUID = 1011;
    
    private static final String INDEX_XHTML = "/index";
    private static final String APP_CONFIG_INDEX_XHTML = "/appconfig/index";
    private static final String APP_CONFIG_EDIT_XHTML = "/appconfig/createOrEdit";
    
    @EJB
    private AppConfigRest restClient;
    
    private AppConfigDto selectedAppConfig;
    private String filterText;
    private List<AppConfigDto> list;
    private boolean isCreate;
    private boolean isEdit;
    private String comingFromViewId;

    public AppConfigMBean() {
    }
    
    public List<AppConfigDto> getAppConfigs(){
        if(list == null) {
            if(filterText != null && filterText.isEmpty()){
                list = restClient.listAppConfig();
            } else {
                list = restClient.filterAppConfig(filterText);
            }
        }
        return list;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }
    
    public void filter(){
        list = null;
    }

    public void reload(){
        list = null;
    }

    public AppConfigDto getSelectedAppConfig() {
        return selectedAppConfig;
    }

    public void setSelectedAppConfig(AppConfigDto selectedAppConfig) {
        this.selectedAppConfig = selectedAppConfig;
    }
    
    private void pushPageComingFrom(){
        comingFromViewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }
    
    private String popPageComingFrom(){
        String pageId = comingFromViewId != null ? comingFromViewId : INDEX_XHTML;
        comingFromViewId = null;
        return pageId;
    }
    
    
    public String startEdit(){
        pushPageComingFrom();
        isEdit = true;
        isCreate = false;
        return APP_CONFIG_EDIT_XHTML;
    }
    
    public String startCreate(){
        pushPageComingFrom();
        isEdit = false;
        isCreate = true;
        selectedAppConfig = new AppConfigDto();
        return APP_CONFIG_EDIT_XHTML;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }
    
    public String edit(){
        try{
            restClient.update(selectedAppConfig);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("appConfigForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedAppConfig = null;
        reload();
        isEdit = false;
        return popPageComingFrom();
    }
    public String create(){
        try{
            restClient.create(selectedAppConfig);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("appConfigForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedAppConfig = null;
        reload();
        isCreate = false;
        return popPageComingFrom();
    }

    public void delete(){
        FacesContext.getCurrentInstance().addMessage("appConfigForm", new FacesMessage("Error","Delete method not yet implemented") ); 
    }
    
}
