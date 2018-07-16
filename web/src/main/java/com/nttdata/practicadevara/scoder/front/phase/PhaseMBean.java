package com.nttdata.practicadevara.scoder.front.phase;

import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@RequestScoped
@Named("phaseMBean")
public class PhaseMBean {
    private PhaseDto newPhase=new PhaseDto();
    private static final String INDEX_XHTML="index";
    private static final String PHASE_EDIT_XHTML="editPhase";
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
    
    public String editPhase(){
        return PHASE_EDIT_XHTML;
    }
    
    public String edit(){
        try{
            restClient.updatePhase(selectedPhase);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("appConfigForm", new FacesMessage("Error",e.getMessage()) );
        }
        selectedPhase = null;
        return INDEX_XHTML;
    }
    
    public void deletePhase(){
//        try {newPhase = new PhaseDto();
           // restClient.deletePhase(oldPhase);
           // oldPhase = ;
//        }catch(BackendException ex){
//            //todo afisare eroare
//        }
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
