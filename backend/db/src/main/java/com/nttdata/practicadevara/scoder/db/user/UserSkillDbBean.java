package com.nttdata.practicadevara.scoder.db.user;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.DBException;
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
       
    public List<UserSkillDbEntity> filterByUserId(Long userId) {
        String param = "%"+userId+"%";
        return manager.createNamedQuery(UserSkillDbEntity.FILTER_BY_USER_ID)
                .setParameter(UserSkillDbEntity.FILTER_BY_USER_ID_PARAM, param)
                .getResultList();
    }
    
    public List<UserSkillDbEntity> filterByPhaseId(Long phaseId) {
        String param = "%"+phaseId+"%";
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
        entity.setUser(e.getUser());
        entity.setPhaseId(e.getPhaseId());
        entity.setName(e.getName());
        entity.setLevel(e.getLevel());
        entity.setComments(e.getComments());
        return super.update(entity);
    }

}