package com.nttdata.practicadevara.scoder.db;

import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class AppConfigDbBean extends AbstractBean<AppConfigDbEntity>{
    @Override
    public String findAllNamedQuery(){
        return AppConfigDbEntity.FIND_ALL;
    }

    @Override
    public String findByIdNamedQuery(){
        return AppConfigDbEntity.FIND_BY_ID;
    }
    
    public List<AppConfigDbEntity> filter(String key) {
        String param = "%"+key+"%";
        return manager.createNamedQuery(AppConfigDbEntity.FILTER_BY_KEY)
                .setParameter(AppConfigDbEntity.FILTER_BY_KEY_PARAM, param)
                .getResultList();
    }
    
    public AppConfigDbEntity update(AppConfigDbEntity e) throws DBException {
        if(e == null){
            throw new DBException("Cannot update entity");
        }
        if(e.getId() == null){
            throw new DBException("Cannot update entity without id");
        }
        AppConfigDbEntity entity = findById(e.getId());
        entity.setKey(e.getKey());
        entity.setValue(e.getValue());
        return super.update(entity);
    }

}
