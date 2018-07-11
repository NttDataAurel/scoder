package com.nttdata.practicadevara.scoder.db;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = UserSkillDbEntity.TBL_APP_CONFIG, schema = AbstractBean.SCHEMA_NAME)
@NamedQueries({
        @NamedQuery(name = UserSkillDbEntity.FIND_ALL, query = "SELECT e FROM UserSkillDbEntity e"),
        @NamedQuery(name = UserSkillDbEntity.FIND_BY_ID, query = "SELECT e FROM UserSkillDbEntity e WHERE e.id=:"+ AbstractBean.ID_PARAM),
        @NamedQuery(name = UserSkillDbEntity.FILTER_BY_USER_ID, query = "SELECT e FROM UserSkillDbEntity e WHERE e.user_id like :"+ UserSkillDbEntity.FILTER_BY_USER_ID_PARAM),
        @NamedQuery(name = UserSkillDbEntity.FILTER_BY_PHASE_ID, query = "Select e FROM UserSkillDbEntity e WHERE e.phase_id like :"+ UserSkillDbEntity.FILTER_BY_PHASE_ID_PARAM),
        @NamedQuery(name = UserSkillDbEntity.FILTER_BY_NAME, query = "Select e FROM UserSkillDbEntity e WHERE e.name like :"+ UserSkillDbEntity.FILTER_BY_NAME_PARAM)
})
public class UserSkillDbEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 117223295272084434L;
    
    public static final String FIND_ALL = "FIND_ALL_JPQL";
    public static final String FIND_BY_ID = "FIND_BY_ID_JPQL";
    public static final String TBL_APP_CONFIG = "app_config";
    public static final String FILTER_BY_USER_ID = "FILTER_BY_USER_ID";
    public static final String FILTER_BY_USER_ID_PARAM = "user_id_param";
    public static final String FILTER_BY_PHASE_ID = "FILTER_BY_PHASE_ID";
    public static final String FILTER_BY_PHASE_ID_PARAM = "phase_id_param";
    public static final String FILTER_BY_NAME = "FILTER_BY_NAME";
    public static final String FILTER_BY_NAME_PARAM = "name_param";
    
    @Column(name = "USER_ID")
    private Integer user_id;
    
    @Column(name = "PHASE_ID")
    private Integer phase_id;
    
    @Column(name = "NAME")
    private String name;

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPhaseId() {
        return phase_id;
    }

    public void setPhaseId(Integer phase_id) {
        this.phase_id = phase_id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSkillDbEntity)) {
            return false;
        }
        UserSkillDbEntity other = (UserSkillDbEntity) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+" [ id=" + getId() + " ]";
    }
}
