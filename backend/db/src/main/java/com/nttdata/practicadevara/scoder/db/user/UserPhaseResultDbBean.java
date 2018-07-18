package com.nttdata.practicadevara.scoder.db.user;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.DBException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UserPhaseResultDbBean extends AbstractBean<UserPhaseResultDbEntity>{
    @Override
    public String findAllNamedQuery(){
        return UserPhaseResultDbEntity.FIND_ALL;
    }

    @Override
    public String findByIdNamedQuery(){
        return UserPhaseResultDbEntity.FIND_BY_ID;
    }
       
    public String findByDateQuery(){
        return UserPhaseResultDbEntity.FIND_BY_DATE;
    }
    
    public String findByUserIdQuery(){
        return UserPhaseResultDbEntity.FIND_BY_USER_ID;
    }
    
    public String findByPhaseIdQuery(){
        return UserPhaseResultDbEntity.FIND_BY_PHASE_ID;
    }
    
    public String findByRankingQuery(){
        return UserPhaseResultDbEntity.FIND_BY_RANKING;
    }
    
    public String findByQuery(){
        return UserPhaseResultDbEntity.FIND_BY_PASSED;
    }
    
    public List<UserPhaseResultDbEntity> filter(String sfilter) {
        String param = "%"+sfilter+"%";
        return manager.createNamedQuery(UserPhaseResultDbEntity.FILTER)
                .setParameter(UserPhaseResultDbEntity.RANKING_PARAM, param)
                .getResultList();
    }
    
    /**
     *
     * @param date
     * @return
     */
    public List<UserPhaseResultDbEntity> filterByDate(Date date) {
        String param = "%"+date+"%";
        return manager.createNamedQuery(UserPhaseResultDbEntity.FIND_BY_DATE)
                .setParameter(UserPhaseResultDbEntity.DATE_PARAM, param)
                .getResultList();
    }
    
    public List<UserPhaseResultDbEntity> filterByUserId(Long userId) {
        String param = "%"+userId+"%";
        return manager.createNamedQuery(UserPhaseResultDbEntity.FIND_BY_USER_ID)
                .setParameter(UserPhaseResultDbEntity.USER_ID_PARAM, param)
                .getResultList();
    }
    
    public List<UserPhaseResultDbEntity> filterByPhaseId(Long phaseId) {
        String param = "%"+phaseId+"%";
        return manager.createNamedQuery(UserPhaseResultDbEntity.FIND_BY_PHASE_ID)
                .setParameter(UserPhaseResultDbEntity.PHASE_ID_PARAM, param)
                .getResultList();
    }
    
    public List<UserPhaseResultDbEntity> filterByRank(double rank) {  
        return manager.createNamedQuery(UserPhaseResultDbEntity.FIND_BY_RANKING)
                .setParameter(UserPhaseResultDbEntity.RANKING_PARAM, rank)
                .getResultList();
    }
    
    public List<UserPhaseResultDbEntity> filterByPassed(boolean pass){
        return manager.createNamedQuery(UserPhaseResultDbEntity.FIND_BY_PASSED)
                .setParameter(UserPhaseResultDbEntity.PASSED_PARAM,pass)
                .getResultList();
    }
    
    @Override
    public UserPhaseResultDbEntity update(UserPhaseResultDbEntity e) throws DBException {
        if(e == null){
            throw new DBException("Cannot update entity");
        }
        if(e.getId() == null){
            throw new DBException("Cannot update entity without id");
        }
        UserPhaseResultDbEntity entity = findById(e.getId());
        entity.setDate(e.getDate());
        entity.setUser(e.getUser());
        entity.setPhaseId(e.getPhaseId());
        entity.setComments(e.getComments());
        entity.setRanking(e.getRanking());
        entity.setPassed(e.getPassed());
        return super.update(entity);
    }

}
