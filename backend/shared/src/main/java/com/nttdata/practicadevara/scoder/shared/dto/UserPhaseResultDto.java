package com.nttdata.practicadevara.scoder.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class UserPhaseResultDto implements Serializable{
    private static final long serialVersionUID = 1001;
    
    private Long id;
    private Date date;
    private Long phaseId;
    private String comments;
    private String ranking;
    private Boolean passed;
    

    public UserPhaseResultDto() {
    }

    public UserPhaseResultDto(Long id, Date date, Long phaseId, String comments, String ranking, Boolean passed) {
        this.id = id;
        this.date = date;
        this.phaseId = phaseId;
        this.comments = comments;
        this.ranking = ranking;
        this.passed = passed;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPhaseId(){
        return phaseId;
    }
    
    public void setPhaseId(Long phaseId){
        this.phaseId = phaseId;
    }
    
    public String getComments(){
        return comments;
    }
    
    public void setComments(String comments){
        this.comments = comments;
    }
    
    public String getRanking(){
        return ranking;
    }
    
    public void setRanking(String ranking){
        this.ranking = ranking;
    }
    
    public Boolean getPassed(){
        return passed;
    }
    
    public void setPassed(Boolean passed){
        this.passed = passed;
    }

}
