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
public class UserPhaseResultMbean implements Serializable {

    private static final long serialVersionUID = 1019;

    private static final String INDEX_XHTML = "/index";
    private static final String USER_PHASE_RESULT_INDEX_XHTML = "/userphaseresult/index";
    private static final String USER_PHASE_RESULT_EDIT_XHTML = "/userphaseresult/createOrEdit";

    @EJB
    private UserPhaseResultRest restClient;

    private UserPhaseResultDto selectedUserPhaseResult;
    private UserPhaseResultDto selectedPhase;
    private String filterText;
    private List<UserPhaseResultDto> list;
    private boolean isCreate;
    private boolean isEdit;
    private String comingFromViewId;

    public UserPhaseResultMbean() {
    }

    public List<UserPhaseResultDto> getUserPhaseResult() {
        if (list == null) {
            if (filterText != null && filterText.isEmpty()) {
                list = restClient.listUserPhaseResult();
            } else {
                list = restClient.filterUserPhaseResult(filterText);
            }
        }
        return list;
    }

    public UserPhaseResultDto getSelectedPhase() {
        return selectedPhase;
    }

    public void setSelectedPhase(UserPhaseResultDto selectedPhase) {
        this.selectedPhase = selectedPhase;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    public void filter() {
        list = null;
    }

    public void reload() {
        list = null;
    }

    public UserPhaseResultDto getSelectedUserPhaseResult() {
        return selectedUserPhaseResult;
    }

    public void setSelectedUserPhaseResult(UserPhaseResultDto selectedUserPhaseResult) {
        this.selectedUserPhaseResult = selectedUserPhaseResult;
    }

    private void pushPageComingFrom() {
        comingFromViewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }

    private String popPageComingFrom() {
        String pageId = comingFromViewId != null ? comingFromViewId : INDEX_XHTML;
        comingFromViewId = null;
        return pageId;
    }

    public String startEdit() {
        isEdit = true;
        isCreate = false;
        return USER_PHASE_RESULT_EDIT_XHTML;
    }

    public String startCreate() {
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

    public String edit() {
        try {
            restClient.update(selectedUserPhaseResult);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("userPhaseResultForm", new FacesMessage("Error", e.getMessage()));
        }
        selectedUserPhaseResult = null;
        reload();
        isEdit = false;
        return popPageComingFrom();
    }

    public String create() {
        try {
            restClient.create(selectedUserPhaseResult);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("userPhaseResultForm", new FacesMessage("Error", e.getMessage()));
        }
        selectedUserPhaseResult = null;
        reload();
        isCreate = false;
        return popPageComingFrom();
    }

    public void delete() {
        FacesContext.getCurrentInstance().addMessage("userPhaseResultForm", new FacesMessage("Error", "Delete method not yet implemented"));
    }

}
