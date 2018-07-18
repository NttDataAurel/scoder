package com.nttdata.practicadevara.scoder.front.user;

import com.nttdata.practicadevara.scoder.front.phase.PhaseRest;
import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import com.nttdata.practicadevara.scoder.shared.dto.UserPhaseResultDto;
import com.nttdata.practicadevara.scoder.shared.exception.BackendException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;

@SessionScoped
@Named("userMBean")
public class UserMBean implements Serializable {

    private static final long serialVersionUID = 10112;

    private static final String USER_XHTML = "/user/index";
    private static final String USER_EDIT_XHTML = "/user/createOrEditUser";

    @EJB
    private UserRest restClient;
    
    @EJB
    private PhaseRest phaseRest;

    private UserDto selectedUser;
    private String filterText;
    private List<UserDto> usersList;
    private boolean isCreate;
    private boolean isEdit;
    private List<PhaseDto> phases;
    
    /**
     * Creates a new instance of AppConfigMBean
     */
    public UserMBean() {
    }

    public void initUsers(){
        usersList = restClient.listUser();
    }
    
    public void initPhases(){
        phases = phaseRest.listPhase();
    }
    
    public List<UserDto> getUsers() {
        if(usersList == null){
            initUsers();
        }
        return usersList;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    public void filter() {
        usersList = null;
    }

    public void reload() {
        usersList = null;
    }

    public UserDto getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserDto selectedUser) {
        this.selectedUser = selectedUser;
    }

    public String startEdit() {
        isEdit = true;
        isCreate = false;
        return USER_EDIT_XHTML;
    }

    public String startCreate() {
        isEdit = false;
        isCreate = true;
        selectedUser = new UserDto();
        return USER_EDIT_XHTML;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }
    
    // value="#{bean.phasesDto}"
    public List<PhaseDto> getPhasesDto() {
        if(phases == null){
            initPhases();
        }
        return phases;
    }

    public String edit() {
        try {
            restClient.update(selectedUser);
        } catch (BackendException | ClientErrorException e) {
            FacesContext.getCurrentInstance().addMessage("userForm", new FacesMessage("Error", e.getMessage()));
        }
        selectedUser = null;
        reload();
        isEdit = false;
        return USER_XHTML;
    }                                                                                                                                   //<----------------

    public String create() {
        try {
            restClient.create(selectedUser);
        } catch (BackendException | ClientErrorException e) {
            FacesContext.getCurrentInstance().addMessage("userForm", new FacesMessage("Error", e.getMessage()));
        }
        selectedUser = null;
        reload();
        isCreate = false;
        return USER_XHTML;
    }

    public void delete() {
        FacesContext.getCurrentInstance().addMessage("appConfigForm", new FacesMessage("Error", "Delete method not yet implemented"));
    }

    public String initEditUserPhaseResults(){
        return "/user/updateUserPhaseResult";
    }
    
    public void addNewUserPhaseResult(){
        UserPhaseResultDto newDto = new UserPhaseResultDto();
        newDto.setDate(new Date());
        selectedUser.getPhaseResults().add(newDto);
    }    
    
    public String updateUserPhaseResults(){
        return edit();
    }

    public String toUserIndex(){
        return "/user/index";
    }
}
