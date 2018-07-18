package com.nttdata.practicadevara.scoder.front.user;

import com.nttdata.practicadevara.scoder.front.phase.PhaseRest;
import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import com.nttdata.practicadevara.scoder.shared.exception.BackendException;
import java.io.Serializable;
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
    private static final String USER_DELETE_XHTML = "/user/createOrEditUser";

    

    @EJB
    private UserRest restClient;
    private UserDto selectedUser;
    private String filterText;
    private List<UserDto> usersList;
    private boolean isCreate;
    private boolean isEdit;
        private boolean isDelete;

    private PhaseRest phaseRest;
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
        isDelete = false;

        return USER_EDIT_XHTML;
    }

    public String startCreate() {
        isEdit = false;
        isCreate = true;
        isDelete = false;

        selectedUser = new UserDto();
        return USER_EDIT_XHTML;
    }
    
     public String startDelete() {
        isEdit = false;
        isCreate = false;
        isDelete = true;

        return USER_DELETE_XHTML;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }
    
    public boolean isIsDelete() {
        return isDelete;
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

    
        
        public void delete(){
        try{
            restClient.delete(selectedUser);
        }
        catch(Exception e){
      
            FacesContext.getCurrentInstance().addMessage("userForm", new FacesMessage("Error","Delete method not yet implemented") ); 
        }
    }
       
    }
    


