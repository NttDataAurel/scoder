package com.nttdata.practicadevara.scoder.front.user;

import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("userMBean")
public class UserMBean  implements Serializable{
    
    private static final long serialVersionUID = 10112;
    
    private static final String USER_XHTML = "/user/user";
    private static final String USER_EDIT_XHTML = "/user/CreateOrEditUser";
    
    @EJB
    private UserRest restClient;
    private UserDto selectedUser;
    private String filterText;
    private List<UserDto> list;
    private boolean isCreate;
    private boolean isEdit;

    /**
     * Creates a new instance of AppConfigMBean
     */
    public UserMBean() {
    }
    
 public List<UserDto> getUsers(){
        List<UserDto> list = restClient.listUser();
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

    public UserDto getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserDto selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    public String startEdit(){
        isEdit = true;
        isCreate = false;
        return USER_EDIT_XHTML;
    }
    
    public String startCreate(){
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
    
    public String edit(){
        try{
            restClient.update(selectedUser);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("userForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedUser = null;
        reload();
        isEdit = false;
        return USER_XHTML;
    }
    public String create(){
        try{
            restClient.create(selectedUser);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("userForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedUser = null;
        reload();
        isCreate = false;
        return USER_XHTML;
    }

    public void delete(){
        FacesContext.getCurrentInstance().addMessage("appConfigForm", new FacesMessage("Error","Delete method not yet implemented") ); 
    }
   
    
}
