package com.nttdata.practicadevara.scoder.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.scoder.shared.dto.PhaseDto;
import com.nttdata.practicadevara.scoder.db.PhaseDbEntity;
import com.nttdata.practicadevara.scoder.db.PhaseDbBean;
import com.nttdata.practicadevara.scoder.db.DBException;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.ejb.EJB;

@Stateless
@LocalBean
public class PhaseBean {

    @EJB
    private PhaseDbBean phaseDbBean;
    
    public List<PhaseDto> list(){
        List<PhaseDbEntity> entities = phaseDbBean.findAll();
        return toDto(entities);
    }
    
    public List<PhaseDto> filterName(String name){
        List<PhaseDbEntity> entities = phaseDbBean.filterName(name);
        return toDto(entities);
    }
    
    public List<PhaseDto> filterPriority(String priority){
        List<PhaseDbEntity> entities = phaseDbBean.filterName(priority);
        return toDto(entities);
    }
    
    public PhaseDto selectByName(String name){
        PhaseDbEntity entity = phaseDbBean.selectByName(name);
        return toDto(entity);
    }
    
    public PhaseDto selectByPriority(String priority){
        PhaseDbEntity entity = phaseDbBean.selectByName(priority);
        return toDto(entity);
    }
    
    public PhaseDto createPhase(PhaseDto dto){
        PhaseDbEntity e = fromDto(dto);
       PhaseDbEntity entity = phaseDbBean.create(e);
        return toDto(entity);
    }
    
    public PhaseDto updatePhase(PhaseDto dto) throws DBException {
        PhaseDbEntity e = fromDto(dto);
        PhaseDbEntity entity = phaseDbBean.update(e);
        return toDto(entity);
    }
    
    public PhaseDto deletePhase(PhaseDto dto) throws DBException {
        PhaseDbEntity e = fromDto(dto);
        PhaseDbEntity entity = phaseDbBean.deletePhase(e);
        return toDto(entity);
    }
    
    private List<PhaseDto> toDto(List<PhaseDbEntity> list){
        if(list != null){
            return list.stream().map(e -> new PhaseDto(e.getId(), e.getName(), e.getDescription(), e.getPriority())).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
    
    private PhaseDto toDto(PhaseDbEntity e){
        if(e != null){
            return new PhaseDto(e.getId(), e.getName(), e.getDescription(), e.getPriority());
        }
        return null;
    }
    
    private PhaseDbEntity fromDto(PhaseDto dto){
        PhaseDbEntity e = new PhaseDbEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setPriority(dto.getPriority());
        return e;
    }

}
