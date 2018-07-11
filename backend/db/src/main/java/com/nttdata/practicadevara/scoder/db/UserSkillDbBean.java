package com.nttdata.practicadevara.scoder.db;

import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UserSkillDbBean extends AbstractBean<UserSkillDbEntity>{
    @Override
    public String findAllNamedQuery(){
        return UserSkillDbEntity.FIND_ALL;
    }

    @Override
    public String findByIdNamedQuery(){
        return UserSkillDbEntity.FIND_BY_ID;
    }
       
    public List<UserSkillDbEntity> filterByUserId(Integer user_id) {
        String param = "%"+user_id+"%";
        return manager.createNamedQuery(UserSkillDbEntity.FILTER_BY_USER_ID)
                .setParameter(UserSkillDbEntity.FILTER_BY_USER_ID_PARAM, param)
                .getResultList();
    }
    
    public List<UserSkillDbEntity> filterByPhaseId(Integer phase_id) {
        String param = "%"+phase_id+"%";
        return manager.createNamedQuery(UserSkillDbEntity.FILTER_BY_PHASE_ID)
                .setParameter(UserSkillDbEntity.FILTER_BY_PHASE_ID_PARAM, param)
                .getResultList();
    }
    
    public List<UserSkillDbEntity> filterByName(String name) {
        String param = "%"+name+"%";
        return manager.createNamedQuery(UserSkillDbEntity.FILTER_BY_NAME)
                .setParameter(UserSkillDbEntity.FILTER_BY_NAME_PARAM, param)
                .getResultList();
    }
    
    public UserSkillDbEntity update(UserSkillDbEntity e) throws DBException {
        if(e == null){
            throw new DBException("Cannot update entity");
        }
        if(e.getId() == null){
            throw new DBException("Cannot update entity without id");
        }
        UserSkillDbEntity entity = findById(e.getId());
        entity.setUserId(e.getUserId());
        entity.setPhaseId(e.getPhaseId());
        return super.update(entity);
    }

}
