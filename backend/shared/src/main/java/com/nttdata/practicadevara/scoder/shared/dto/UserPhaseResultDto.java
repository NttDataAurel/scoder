package com.nttdata.practicadevara.scoder.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class UserPhaseResultDto implements Serializable{
    private static final long serialVersionUID = 1001;
    
    private Long id;
    private Date date;
    private Long userId;
    private Long phaseId;
    private String comments;
    private String ranking;
    private boolean passed;
    

    public UserPhaseResultDto() {
    }

    public UserPhaseResultDto(Long id, Date date, Long userId, Long phaseId, String comments, String ranking, boolean passed) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.phaseId = phaseId;
        this.comments = comments;
        this.ranking = ranking;
        this.passed = passed;
    }

    public UserPhaseResultDto(Long id, String name, String surname, String address, int phone, String email, String filename, String _file, int state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
    
    public boolean getPassed(){
        return passed;
    }
    
    public void setPassed(boolean passed){
        this.passed = passed;
    }  
}
