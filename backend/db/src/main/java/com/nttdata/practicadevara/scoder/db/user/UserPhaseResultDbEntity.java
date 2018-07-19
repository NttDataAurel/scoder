package com.nttdata.practicadevara.scoder.db.user;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = UserPhaseResultDbEntity.TBL_USER_PHASE_RESULT, schema = AbstractBean.SCHEMA_NAME)
@NamedQueries({
        @NamedQuery(name = UserPhaseResultDbEntity.FIND_ALL, query = "SELECT e FROM UserPhaseResultDbEntity e"),
        @NamedQuery(name = UserPhaseResultDbEntity.FIND_BY_ID, query = "SELECT e FROM UserPhaseResultDbEntity e WHERE e.id=:"+ AbstractBean.ID_PARAM),
        @NamedQuery(name = UserPhaseResultDbEntity.FIND_BY_DATE, query ="SELECT e FROM UserPhaseResultDbEntity e WHERE e.date=:"+UserPhaseResultDbEntity.DATE_PARAM),
        @NamedQuery(name = UserPhaseResultDbEntity.FIND_BY_USER_ID, query="SELECT e FROM UserPhaseResultDbEntity e WHERE e.user.id=:"+UserPhaseResultDbEntity.USER_ID_PARAM),
        @NamedQuery(name = UserPhaseResultDbEntity.FIND_BY_PHASE_ID, query="SELECT e FROM UserPhaseResultDbEntity e WHERE e.phaseId=:"+UserPhaseResultDbEntity.PHASE_ID_PARAM),
        @NamedQuery(name = UserPhaseResultDbEntity.FIND_BY_RANKING, query="SELECT e FROM UserPhaseResultDbEntity e WHERE e.ranking>:"+UserPhaseResultDbEntity.RANKING_PARAM),
        @NamedQuery(name = UserPhaseResultDbEntity.FIND_BY_PASSED, query="SELECT e FROM UserPhaseResultDbEntity e WHERE e.passed=:"+UserPhaseResultDbEntity.PASSED_PARAM),
        @NamedQuery(name = UserPhaseResultDbEntity.FILTER, query="SELECT e FROM UserPhaseResultDbEntity e WHERE e.ranking like :"+UserPhaseResultDbEntity.RANKING_PARAM)
})

public class UserPhaseResultDbEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 118334295272084434L;
    
    public static final String FIND_ALL = "USER_PHASE_RESULT_FIND_ALL_JPQL";
    public static final String FIND_BY_ID = "USER_PHASE_RESULT_FIND_BY_ID_JPQL";
    public static final String FIND_BY_DATE="USER_PHASE_RESULT_FIND_BY_DATE_JPQL";
    public static final String FIND_BY_USER_ID="USER_PHASE_RESULT_FIND_BY_USER_ID_JPQL";
    public static final String FIND_BY_PHASE_ID="USER_PHASE_RESULT_FIND_BY_PHASE_ID_JPQL";
    public static final String FIND_BY_RANKING="USER_PHASE_RESULT_FIND_BY_RANKING_JPQL";
    public static final String FIND_BY_PASSED="USER_PHASE_RESULT_FIND_BY_PASSED_JPQL";
    public static final String FILTER="USER_PHASE_RESULT_FILTER_JPQL";
    public static final String TBL_USER_PHASE_RESULT = "user_phase_result";
    public static final String FILTER_BY_KEY = "USER_PHASE_RESULT_FILTER_BY_KEY";
    public static final String FILTER_BY_KEY_PARAM = "key_param";
    public static final String DATE_PARAM = "date_param";
    public static final String USER_ID_PARAM = "user_id_param";
    public static final String PHASE_ID_PARAM = "phase_id_param";
    public static final String RANKING_PARAM = "ranking_param";
    public static final String PASSED_PARAM = "passed_param";
    public static final String FILTER_PARAM = "filter_param";
    
    @Temporal(TemporalType.DATE)
    @Column(name = "_DATE")
    private Date date;
    
    @Column(name = "PHASE_ID")
    private Long phaseId;
    
    @Column(name = "COMMENTS")
    private String comments;
    
    @Column(name ="RANKING")
    private String ranking;
    
    @Column(name ="PASSED")
    private Boolean passed;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "USER_ID")
    private UserDbEntity user;
    
    @PrePersist
    @PreUpdate
    private void checkValues(){
        if(date == null){
            date = new Date();
        }
        if(passed == null){
            passed = false;
        }
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
    
    public void setPhaseId(Long phase_id){
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
    
    public Boolean getPassed(){
        return passed;
    }
    
    public void setPassed(Boolean passed){
        this.passed = passed;
    }

    public UserDbEntity getUser() {
        return user;
    }

    public void setUser(UserDbEntity user) {
        this.user = user;
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
        if (!(object instanceof UserPhaseResultDbEntity)) {
            return false;
        }
        UserPhaseResultDbEntity other = (UserPhaseResultDbEntity) object;
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
