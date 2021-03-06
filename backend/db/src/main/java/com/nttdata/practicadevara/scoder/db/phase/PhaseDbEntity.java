package com.nttdata.practicadevara.scoder.db.phase;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.AbstractEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = PhaseDbEntity.TBL_PHASE, schema = AbstractBean.SCHEMA_NAME)
@NamedQueries({
        @NamedQuery(name = PhaseDbEntity.FIND_ALL, query = "SELECT e FROM PhaseDbEntity e"),
        @NamedQuery(name = PhaseDbEntity.FIND_BY_ID, query = "SELECT e FROM PhaseDbEntity e WHERE e.id=:"+AbstractBean.ID_PARAM),
        @NamedQuery(name = PhaseDbEntity.SELECT_BY_NAME, query = "SELECT e FROM PhaseDbEntity e WHERE e.name like :"+ PhaseDbEntity.PARAM_NAME),
        @NamedQuery(name = PhaseDbEntity.SELECT_BY_PRIORITY, query = "SELECT e FROM PhaseDbEntity e WHERE e.priority = :"+ PhaseDbEntity.PARAM_PRIORITY),
        @NamedQuery(name = PhaseDbEntity.DELETE_BY_NAME, query = "DELETE FROM PhaseDbEntity e WHERE e.name = :"+ PhaseDbEntity.PARAM_NAME)
})
public class PhaseDbEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 117223295272084434L;
    
    public static final String FIND_ALL = "FIND_ALL_PHASES_JPQL";
    public static final String FIND_BY_ID = "FIND_BY_ID_PHASES_JPQL";
    public static final String SELECT_BY_NAME = "SELECT_PHASES_BY_NAME_JPQL";
    public static final String SELECT_BY_PRIORITY = "SELECT_PHASES_BY_PRIORITY_JPQL";
    public static final String TBL_PHASE = "phase";
    public static final String DELETE_BY_NAME = "DELETE_PHASES_BY_NAME";
    public static final String PARAM_NAME = "PARAM_PHASES_NAME";
    public static final String PARAM_PRIORITY = "PARAM_PHASES_PRIORITY";
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "priority")
    private Integer priority;

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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhaseDbEntity)) {
            return false;
        }
        PhaseDbEntity other = (PhaseDbEntity) object;
        /*if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+" [ id=" + getId() + " ]";
    }
}
