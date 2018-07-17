package com.nttdata.practicadevara.scoder.shared.dto;

import java.io.Serializable;

public class UserSkillDto implements Serializable{
    private static final long serialVersionUID = 1537;
    
    private Long id=null;
    private Long userId;
    private Long phaseId;
    private String name;
    private Long level;
    private String comments;

    public UserSkillDto() {
    }

    public UserSkillDto(Long id, Long userId, Long phaseId, String name, Long level, String comments) {
        this.id = id;
        this.userId = userId;
        this.phaseId = phaseId;
        this.name = name;
        this.level = level;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Long phaseId) {
        this.phaseId = phaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
