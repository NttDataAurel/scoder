package com.nttdata.practicadevara.scoder.db;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = AppConfigDbEntity.TBL_APP_CONFIG, schema = AbstractBean.SCHEMA_NAME)
@NamedQueries({
        @NamedQuery(name = AppConfigDbEntity.FIND_ALL, query = "SELECT e FROM AppConfigDbEntity e"),
        @NamedQuery(name = AppConfigDbEntity.FIND_BY_ID, query = "SELECT e FROM AppConfigDbEntity e WHERE e.id=:"+ AbstractBean.ID_PARAM),
        @NamedQuery(name = AppConfigDbEntity.FILTER_BY_KEY, query = "SELECT e FROM AppConfigDbEntity e WHERE e.key like :"+ AppConfigDbEntity.FILTER_BY_KEY_PARAM)
})
public class AppConfigDbEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 117223295272084434L;
    
    public static final String FIND_ALL = "FIND_ALL_JPQL";
    public static final String FIND_BY_ID = "FIND_BY_ID_JPQL";
    public static final String TBL_APP_CONFIG = "app_config";
    public static final String FILTER_BY_KEY = "FILTER_BY_KEY";
    public static final String FILTER_BY_KEY_PARAM = "key_param";
    
    @Column(name = "_KEY")
    private String key;
    
    @Column(name = "_VALUE")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        if (!(object instanceof AppConfigDbEntity)) {
            return false;
        }
        AppConfigDbEntity other = (AppConfigDbEntity) object;
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
