package com.nttdata.practicadevara.scoder.front.userskill;

import com.nttdata.practicadevara.scoder.shared.dto.UserSkillDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("userSkillMBean")
public class UserSkillMBean implements Serializable{
    
    private static final long serialVersionUID = 1019;
    
    private static final String INDEX_XHTML = "/index";
    private static final String USER_SKILL_INDEX_XHTML = "/userskill/index";
    private static final String USER_SKILL_EDIT_XHTML = "/userskill/createOrEdit";
    
    @EJB
    private UserSkillRest restClient;
    
    private UserSkillDto selectedUserSkill;
    private String filterByNameTxt;
    private List<UserSkillDto> list;
    private boolean isCreate;
    private boolean isEdit;
    private String comingFromViewIdUserSkill;

public UserSkillMBean() {
    }
    
    public List<UserSkillDto> getUserSkills(){
        if(list == null) {
            if(filterByNameTxt != null && filterByNameTxt.isEmpty()){
                list = restClient.listUserSkill();
            } else {
                list = restClient.filterByNameUserSkill(filterByNameTxt);
            }
        }
        return list;
    }

    public String getFilterByNameTxt() {
        return filterByNameTxt;
    }

    public void setFilterByNameTxt(String filterByNameTxt) {
        this.filterByNameTxt = filterByNameTxt;
    }
    
    public void filterByName(){
        list = null;
    }

    public void reload(){
        list = null;
    }

    public UserSkillDto getSelectedUserSkill() {
        return selectedUserSkill;
    }

    public void setSelectedUserSkill(UserSkillDto selectedUserSkill) {
        this.selectedUserSkill = selectedUserSkill;
    }
    
    private void pushPageComingFromUserSkill(){
        comingFromViewIdUserSkill = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }
    
    private String popPageComingFromUserSkill(){
        String userSkillPageId = comingFromViewIdUserSkill != null ? comingFromViewIdUserSkill : USER_SKILL_INDEX_XHTML;
        comingFromViewIdUserSkill = null;
        return userSkillPageId;
    }
    
    public String startEdit(){
        isEdit = true;
        isCreate = false;
        return USER_SKILL_EDIT_XHTML;
    }
    
    public String startCreate(){
        isEdit = false;
        isCreate = true;
        selectedUserSkill = new UserSkillDto();
        return USER_SKILL_EDIT_XHTML;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }
    
    public String edit(){
        try{
            restClient.update(selectedUserSkill);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("userSkillForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedUserSkill = null;
        reload();
        isEdit = false;
        return popPageComingFromUserSkill();
    }
    public String create(){
        try{
            restClient.create(selectedUserSkill);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("userSkillForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedUserSkill = null;
        reload();
        isCreate = false;
        return popPageComingFromUserSkill();
    }

    public void delete(){
        FacesContext.getCurrentInstance().addMessage("userSkillForm", new FacesMessage("Error","Delete method not yet implemented") ); 
    }
  
}
