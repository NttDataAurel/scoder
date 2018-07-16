package com.nttdata.practicadevara.scoder.front.userphaseresult;

import com.nttdata.practicadevara.scoder.shared.dto.UserPhaseResultDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("userPhaseResultMBean")
public class UserPhaseResultMbean implements Serializable{
    
    private static final long serialVersionUID = 1019;
    
    private static final String INDEX_XHTML = "index";
    private static final String USER_PHASE_RESULT_EDIT_XHTML = "createOrEdit";
    
    @EJB
    private UserPhaseResultRest restClient;
    
    private UserPhaseResultDto selectedUserPhaseResult;
    private String filterText;
    private List<UserPhaseResultDto> list;
    private boolean isCreate;
    private boolean isEdit;

    public UserPhaseResultMbean() {
    }
    
    public List<UserPhaseResultDto> getUserPhaseResult(){
        if(list == null) {
            if(filterText != null && filterText.isEmpty()){
                list = restClient.listUserPhaseResult();
            } else {
                list = restClient.filterUserPhaseResult(filterText);
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

    public UserPhaseResultDto getSelectedUserPhaseResult() {
        return selectedUserPhaseResult;
    }

    public void setSelectedUserPhaseResult(UserPhaseResultDto selectedUserPhaseResult) {
        this.selectedUserPhaseResult = selectedUserPhaseResult;
    }
    
    public String startEdit(){
        isEdit = true;
        isCreate = false;
        return USER_PHASE_RESULT_EDIT_XHTML;
    }
    
    public String startCreate(){
        isEdit = false;
        isCreate = true;
        selectedUserPhaseResult = new UserPhaseResultDto();
        return USER_PHASE_RESULT_EDIT_XHTML;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }
    
    public String edit(){
        try{
            restClient.update(selectedUserPhaseResult);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("userPhaseResultForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedUserPhaseResult = null;
        reload();
        isEdit = false;
        return INDEX_XHTML;
    }
    public String create(){
        try{
            restClient.create(selectedUserPhaseResult);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("userPhaseResultForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedUserPhaseResult = null;
        reload();
        isCreate = false;
        return INDEX_XHTML;
    }

    public void delete(){
        System.out.println("Delete "+selectedUserPhaseResult);
        //restClient.delete(entryToDelete);
    }
  
}
