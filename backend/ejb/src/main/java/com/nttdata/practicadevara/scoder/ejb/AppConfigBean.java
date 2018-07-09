package com.nttdata.practicadevara.scoder.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.scoder.shared.dto.AppConfigDto;
import com.nttdata.practicadevara.scoder.db.AppConfigDbEntity;
import com.nttdata.practicadevara.scoder.db.AppConfigDbBean;
import com.nttdata.practicadevara.scoder.db.DBException;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.ejb.EJB;

@Stateless
@LocalBean
public class AppConfigBean {

    @EJB
    private AppConfigDbBean appConfigDbBean;
    
    public List<AppConfigDto> list(){
        List<AppConfigDbEntity> entities = appConfigDbBean.findAll();
        return toDto(entities);
    }
    
    public List<AppConfigDto> filter(String key){
        List<AppConfigDbEntity> entities = appConfigDbBean.filter(key);
        return toDto(entities);
    }
    public AppConfigDto findById(Long id){
        AppConfigDbEntity entity = appConfigDbBean.findById(id);
        return toDto(entity);
    }
    
    public AppConfigDto create(AppConfigDto dto){
        AppConfigDbEntity e = fromDto(dto);
        AppConfigDbEntity entity = appConfigDbBean.create(e);
        return toDto(entity);
    }
    
    public AppConfigDto update(AppConfigDto dto) throws DBException {
        AppConfigDbEntity e = fromDto(dto);
        AppConfigDbEntity entity = appConfigDbBean.update(e);
        return toDto(entity);
    }
    
    private List<AppConfigDto> toDto(List<AppConfigDbEntity> list){
        if(list != null){
            return list.stream().map(e -> new AppConfigDto(e.getId(), e.getKey(), e.getValue())).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
    
    private AppConfigDto toDto(AppConfigDbEntity e){
        if(e != null){
            return new AppConfigDto(e.getId(), e.getKey(), e.getValue());
        }
        return null;
    }
    
    private AppConfigDbEntity fromDto(AppConfigDto dto){
        AppConfigDbEntity e = new AppConfigDbEntity();
        e.setId(dto.getId());
        e.setKey(dto.getKey());
        e.setValue(dto.getValue());
        return e;
    }

}
