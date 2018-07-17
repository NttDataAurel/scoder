package com.nttdata.practicadevara.scoder.front.phase;

import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import com.nttdata.practicadevara.scoder.shared.exception.BackendException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("phaseMBean")
public class PhaseMBean implements Serializable{
    private static final long serialVersionUID = 1015;
    private PhaseDto newPhase=new PhaseDto();
    private static final String INDEX_XHTML="/phase/index";
    private static final String PHASE_EDIT_XHTML="/phase/phaseEdit";
    private String comingFromViewId;
    private PhaseDto selectedPhase;
    private String oldPhase;
    
    @EJB
    private PhaseRest restClient;

    /**
     * Creates a new instance of PhaseMBean
     */
    public PhaseMBean() {
    }
    
    public List<PhaseDto> getPhases(){
        List<PhaseDto> list = restClient.listPhase();
        return list;
    }
    
    
    public void createPhase(){
//        try {newPhase = new PhaseDto();
            restClient.createPhase(newPhase);
            newPhase = new PhaseDto();
//        }catch(BackendException ex){
//            //todo afisare eroare
//        }
    }
    
    public PhaseDto getSelectedPhase() {
        return selectedPhase;
    }
    
    public void setSelectedPhase(PhaseDto selectedPhase) {
        this.selectedPhase=selectedPhase;
    }
    
    private void pushPageComingFrom(){
        comingFromViewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }
    
    private String popPageComingFrom(){
        String pageId = comingFromViewId != null ? comingFromViewId : INDEX_XHTML;
        comingFromViewId = null;
        return pageId;
    }
    
    public String editPhase(){
        pushPageComingFrom();
        return PHASE_EDIT_XHTML;
    }
    
    public String edit(){
        try{
            restClient.updatePhase(selectedPhase);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("phaseForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedPhase = null;
        return popPageComingFrom();
    }
    
    public void deletePhase(){
        try{
            restClient.deletePhase(selectedPhase);
        }
        catch(Exception e){
        FacesContext.getCurrentInstance().addMessage("phaseForm", new FacesMessage("Error","Delete method not yet implemented") ); 
        }
    }
    
    public PhaseDto getNewPhase() {
        return newPhase;
    }

    public void setNewPhase(PhaseDto newPhase) {
        this.newPhase = newPhase;
    }
    
    public String getOldPhase(){
        return oldPhase;
    }
    
    public void setOldPhase(String oldPhase){
        this.oldPhase=oldPhase;
    }
}
