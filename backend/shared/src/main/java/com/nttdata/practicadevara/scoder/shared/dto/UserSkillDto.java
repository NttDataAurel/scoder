package com.nttdata.practicadevara.scoder.shared.dto;

import java.io.Serializable;

public class UserSkillDto implements Serializable{
    private static final long serialVersionUID = 1537;
    
    private Long id;
    private Long user_id;
    private Long phase_id;
    private String name;
    private Long level;
    private String comments;

    public UserSkillDto() {
    }

    public UserSkillDto(Long id, Long user_id, Long phase_id, String name, Long level, String comments) {
        this.id = id;
        this.user_id = user_id;
        this.phase_id = phase_id;
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
        return user_id;
    }

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public Long getPhaseId() {
        return phase_id;
    }

    public void setPhaseId(Long phase_id) {
        this.phase_id = phase_id;
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
