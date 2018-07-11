package com.nttdata.practicadevara.scoder.db;

import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UserPhaseResultBean extends AbstractBean<UserPhaseResultEntity>{
    @Override
    public String findAllNamedQuery(){
        return UserPhaseResultEntity.FIND_ALL;
    }

    @Override
    public String findByIdNamedQuery(){
        return UserPhaseResultEntity.FIND_BY_ID;
    }
    
    
    public String findByDateQuery(){
        return UserPhaseResultEntity.FIND_BY_DATE;
    }
    
    public String findByUserIdQuery(){
        return UserPhaseResultEntity.FIND_BY_USER_ID;
    }
    
    public String findByPhaseIdQuery(){
        return UserPhaseResultEntity.FIND_BY_PHASE_ID;
    }
    
    public String findByRankingQuery(){
        return UserPhaseResultEntity.FIND_BY_RANKING;
    }
    
    public String findByQuery(){
        return UserPhaseResultEntity.FIND_BY_PASSED;
    }
    
    public List<UserPhaseResultEntity> filterByDate(String date) {
        String param = "%"+date+"%";
        return manager.createNamedQuery(UserPhaseResultEntity.FIND_BY_DATE)
                .setParameter(UserPhaseResultEntity.DATE_PARAM, param)
                .getResultList();
    }
    
    public List<UserPhaseResultEntity> filterByPhaseId(String phaseId) {
        String param = "%"+phaseId+"%";
        return manager.createNamedQuery(UserPhaseResultEntity.FIND_BY_PHASE_ID)
                .setParameter(UserPhaseResultEntity.PHASE_ID_PARAM, param)
                .getResultList();
    }
    
    public List<UserPhaseResultEntity> filterByRank(double rank) {
    
        return manager.createNamedQuery(UserPhaseResultEntity.FIND_BY_RANKING)
                .setParameter(UserPhaseResultEntity.RANKING_PARAM, rank)
                .getResultList();
    }
    
    @Override
    public UserPhaseResultEntity update(UserPhaseResultEntity e) throws DBException {
        if(e == null){
            throw new DBException("Cannot update entity");
        }
        if(e.getId() == null){
            throw new DBException("Cannot update entity without id");
        }
        UserPhaseResultEntity entity = findById(e.getId());
        entity.setDate(e.getDate());
        entity.setUserId(e.getUserId());
        entity.setPhaseId(e.getPhaseId());
        entity.setComments(e.getComments());
        entity.setRanking(e.getRanking());
        entity.setPassed(e.getPassed());
        return super.update(entity);
    }

}
