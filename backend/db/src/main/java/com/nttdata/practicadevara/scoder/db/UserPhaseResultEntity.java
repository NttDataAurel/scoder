package com.nttdata.practicadevara.scoder.db;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = UserPhaseResultEntity.TBL_USER_PHASE_RES, schema = AbstractBean.SCHEMA_NAME)
@NamedQueries({
        @NamedQuery(name = UserPhaseResultEntity.FIND_ALL, query = "SELECT e FROM UserPhaseResultEntity e"),
        @NamedQuery(name = UserPhaseResultEntity.FIND_BY_ID, query = "SELECT e FROM UserPhaseResultEntity e WHERE e.id=:"+ AbstractBean.ID_PARAM),
        @NamedQuery(name = UserPhaseResultEntity.FIND_BY_DATE, query ="SELECT e FROM UserPhaseResultEntity e WHERE e._date=:"+UserPhaseResultEntity.DATE_PARAM),
        @NamedQuery(name = UserPhaseResultEntity.FIND_BY_USER_ID, query="SELECT e FROM UserPhaseResultEntity e WHERE e.user_id=:"+UserPhaseResultEntity.USER_ID_PARAM),
        @NamedQuery(name = UserPhaseResultEntity.FIND_BY_PHASE_ID, query="SELECT e FROM UserPhaseResultEntity e WHERE e.phase_id=:"+UserPhaseResultEntity.PHASE_ID_PARAM),
        @NamedQuery(name = UserPhaseResultEntity.FIND_BY_RANKING, query="SELECT e FROM UserPhaseResultEntity e WHERE e.ranking>:"+UserPhaseResultEntity.RANKING_PARAM),
        @NamedQuery(name = UserPhaseResultEntity.FIND_BY_PASSED, query="SELECT e FROM UserPhaseResultEntity e WHERE e.passed=:"+UserPhaseResultEntity.PASSED_PARAM),
        @NamedQuery(name = UserPhaseResultEntity.FILTER_BY_KEY, query = "SELECT e FROM UserPhaseResultEntity e WHERE e.key like :"+ UserPhaseResultEntity.FILTER_BY_KEY_PARAM)
})

public class UserPhaseResultEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 118334295272084434L;
    
    public static final String FIND_ALL = "FIND_ALL_JPQL";
    public static final String FIND_BY_ID = "FIND_BY_ID_JPQL";
    public static final String FIND_BY_DATE="FIND_BY_DATE_JPQL";
    public static final String FIND_BY_USER_ID="FIND_BY_USER_ID_JPQL";
    public static final String FIND_BY_PHASE_ID="FIND_BY_PHASE_ID_JPQL";
    public static final String FIND_BY_RANKING="FIND_BY_RANKING_JPQL";
    public static final String FIND_BY_PASSED="FIND_BY_PASSED_JPQL";
    public static final String TBL_USER_PHASE_RES = "user_phase_result";
    public static final String FILTER_BY_KEY = "FILTER_BY_KEY";
    public static final String FILTER_BY_KEY_PARAM = "key_param";
    public static final String DATE_PARAM = "date_param";
    public static final String USER_ID_PARAM = "user_id_param";
    public static final String PHASE_ID_PARAM = "phase_id_param";
    public static final String RANKING_PARAM = "ranking_param";
    public static final String PASSED_PARAM = "passed_param";
    
    @Column(name = "_DATE")
    private String date;
    
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "PHASE_ID")
    private long phaseId;
    
    @Column(name = "COMMENTS")
    private String comments;
    
    @Column(name ="RANKING")
    private String ranking;
    
    @Column(name ="PASSED")
    private boolean passed;
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }
    
    public void setUserId(long user_id) {
        this.userId = user_id;
    }
    
    public long getPhaseId(){
        return phaseId;
    }
    
    public void setPhaseId(long phase_id){
        this.phaseId = phase_id;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPhaseResultEntity)) {
            return false;
        }
        UserPhaseResultEntity other = (UserPhaseResultEntity) object;
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
