package com.nttdata.practicadevara.scoder.db;

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
                .setParameter(PhaseDbEntity.PARAM_BY_NAME, name)
                .getSingleResult();
    }
    
    public PhaseDbEntity selectByPriority(String priority) {
        return (PhaseDbEntity) manager
                .createNamedQuery(selectByPriorityNamedQuery())
                .setParameter(PhaseDbEntity.PARAM_BY_NAME, priority)
                .getSingleResult();
    }

    public List<PhaseDbEntity> filterName(String name) {
        String param = "%"+name+"%";
        return manager.createNamedQuery(PhaseDbEntity.SELECT_BY_NAME)
                .setParameter(PhaseDbEntity.PARAM_BY_NAME, param)
                .getResultList();
    }
    
    public List<PhaseDbEntity> filterPriority(String priority) {
        String param = "%"+priority+"%";
        return manager.createNamedQuery(PhaseDbEntity.SELECT_BY_PRIORITY)
                .setParameter(PhaseDbEntity.PARAM_BY_NAME, param)
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
        return super.update(entity);
    }

    public void deletePhase(String name) throws DBException {
        PhaseDbEntity entity =selectByName(name);
        if (entity != null) {
            manager.remove(entity);
        }
    }
   
    @Override
    public String findByIdNamedQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PhaseDbEntity deletePhase(PhaseDbEntity e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
