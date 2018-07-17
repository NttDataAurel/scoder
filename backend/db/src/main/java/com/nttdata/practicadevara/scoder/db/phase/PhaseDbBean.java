package com.nttdata.practicadevara.scoder.db.phase;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.DBException;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PhaseDbBean extends AbstractBean<PhaseDbEntity>{
    
    @Override
    public String findAllNamedQuery(){
        return PhaseDbEntity.FIND_ALL;
    }

    public String selectByNameNamedQuery(){
        return PhaseDbEntity.SELECT_BY_NAME;
    }
    
    public String selectByPriorityNamedQuery(){
        return PhaseDbEntity.SELECT_BY_PRIORITY;
    }
    
    public PhaseDbEntity selectByName(String name) {
        return (PhaseDbEntity) manager
                .createNamedQuery(selectByNameNamedQuery())
                .setParameter(PhaseDbEntity.PARAM_NAME, name)
                .getSingleResult();
    }
    
    public PhaseDbEntity selectByPriority(String priority) {
        return (PhaseDbEntity) manager
                .createNamedQuery(selectByPriorityNamedQuery())
                .setParameter(PhaseDbEntity.PARAM_PRIORITY, priority)
                .getSingleResult();
    }

    public List<PhaseDbEntity> filterName(String name) {
        String param = "%"+name+"%";
        return manager.createNamedQuery(PhaseDbEntity.SELECT_BY_NAME)
                .setParameter(PhaseDbEntity.PARAM_NAME, param)
                .getResultList();
    }
    
    public List<PhaseDbEntity> filterPriority(Integer priority) {
        return manager.createNamedQuery(PhaseDbEntity.SELECT_BY_PRIORITY)
                .setParameter(PhaseDbEntity.PARAM_PRIORITY, priority)
                .getResultList();
    }
    
    public PhaseDbEntity updatePhase(PhaseDbEntity e) throws DBException {
        if(e == null){
            throw new DBException("Cannot update entity");
        }
        if(e.getId() == null){
            throw new DBException("Cannot update entity without id");
        }
        PhaseDbEntity entity = findById(e.getId());
        entity.setName(e.getName());
        entity.setDescription(e.getDescription());
        entity.setPriority(e.getPriority());
        return super.update(entity);
    }

    public void deletePhase(String name) throws DBException {
        PhaseDbEntity entity = selectByName(name);
        if (entity != null) {
            manager.remove(entity);
        }
    }
    
    @Override
    public String findByIdNamedQuery() {
        return PhaseDbEntity.FIND_BY_ID;
    }
    
}
