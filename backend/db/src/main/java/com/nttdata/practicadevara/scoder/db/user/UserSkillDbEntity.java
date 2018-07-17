package com.nttdata.practicadevara.scoder.db.user;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.AbstractEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = UserSkillDbEntity.TBL_USER_SKILL, schema = AbstractBean.SCHEMA_NAME)
@NamedQueries({
        @NamedQuery(name = UserSkillDbEntity.FIND_ALL, query = "SELECT e FROM UserSkillDbEntity e"),
        @NamedQuery(name = UserSkillDbEntity.FIND_BY_ID, query = "SELECT e FROM UserSkillDbEntity e WHERE e.id=:"+ AbstractBean.ID_PARAM),
        @NamedQuery(name = UserSkillDbEntity.FILTER_BY_USER_ID, query = "SELECT e FROM UserSkillDbEntity e WHERE e.userId like :"+ UserSkillDbEntity.FILTER_BY_USER_ID_PARAM),
        @NamedQuery(name = UserSkillDbEntity.FILTER_BY_PHASE_ID, query = "Select e FROM UserSkillDbEntity e WHERE e.phaseId like :"+ UserSkillDbEntity.FILTER_BY_PHASE_ID_PARAM),
        @NamedQuery(name = UserSkillDbEntity.FILTER_BY_NAME, query = "Select e FROM UserSkillDbEntity e WHERE e.name like :"+ UserSkillDbEntity.FILTER_BY_NAME_PARAM)
})
public class UserSkillDbEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 117223295272084434L;
    
    public static final String FIND_ALL = "USER_SKILL_FIND_ALL_JPQL";
    public static final String FIND_BY_ID = "USER_SKILL_FIND_BY_ID_JPQL";
    public static final String TBL_USER_SKILL = "user_skill";
    public static final String FILTER_BY_USER_ID = "USER_SKILL_FILTER_BY_USER_ID";
    public static final String FILTER_BY_USER_ID_PARAM = "userId_param";
    public static final String FILTER_BY_PHASE_ID = "USER_SKILL_FILTER_BY_PHASE_ID";
    public static final String FILTER_BY_PHASE_ID_PARAM = "phaseId_param";
    public static final String FILTER_BY_NAME = "USER_SKILL_FILTER_BY_NAME";
    public static final String FILTER_BY_NAME_PARAM = "name_param";
   
    @Column(name = "USER_ID")
    private Long userId;
    
    @Column(name = "PHASE_ID")
    private Long phaseId;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "LEVEL")
    private Long level;
    
    @Column(name = "COMMENTS")
    private String comments;

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
