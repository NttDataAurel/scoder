package com.nttdata.practicadevara.scoder.shared.dto;

import java.io.Serializable;

public class PhaseDto implements Serializable{
    private static final long serialVersionUID = 1001;
    
    private Long id=null;
    private String name;
    private String description;
    private Integer priority;

    public PhaseDto() {
    }

    public PhaseDto(Long id, String name, String description, Integer priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
