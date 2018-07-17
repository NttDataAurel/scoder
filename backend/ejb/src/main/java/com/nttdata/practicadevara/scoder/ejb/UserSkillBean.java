package com.nttdata.practicadevara.scoder.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.scoder.shared.dto.UserSkillDto;
import com.nttdata.practicadevara.scoder.db.UserSkillDbEntity;
import com.nttdata.practicadevara.scoder.db.UserSkillDbBean;
import com.nttdata.practicadevara.scoder.db.DBException;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.ejb.EJB;

@Stateless
@LocalBean
public class UserSkillBean {

    @EJB
    private UserSkillDbBean userSkillDbBean;
    
    public List<UserSkillDto> list(){
        List<UserSkillDbEntity> entities = userSkillDbBean.findAll();
        return toDto(entities);
    }
    
    public UserSkillDto findById(Long id){
        UserSkillDbEntity entity = userSkillDbBean.findById(id);
        return toDto(entity);
    }
    
    public List<UserSkillDto> filterByUserId(Long userId){
        List<UserSkillDbEntity> entities = userSkillDbBean.filterByUserId(userId);
        return toDto(entities);
    }

    public List<UserSkillDto> filterByPhaseId(Long phaseId){
        List<UserSkillDbEntity> entities = userSkillDbBean.filterByPhaseId(phaseId);
        return toDto(entities);
    }
    
    public List<UserSkillDto> filterByName(String name){
        List<UserSkillDbEntity> entities = userSkillDbBean.filterByName(name);
        return toDto(entities);
    }
    
    public UserSkillDto create(UserSkillDto dto){
        UserSkillDbEntity e = fromDto(dto);
        UserSkillDbEntity entity = userSkillDbBean.create(e);
        return toDto(entity);
    }
    
    public UserSkillDto update(UserSkillDto dto) throws DBException {
        UserSkillDbEntity e = fromDto(dto);
        UserSkillDbEntity entity = userSkillDbBean.update(e);
        return toDto(entity);
    }
    
    private List<UserSkillDto> toDto(List<UserSkillDbEntity> list){
        if(list != null){
            return list.stream().map(e -> new UserSkillDto(e.getId(), e.getUserId(), e.getPhaseId(), e.getName(), e.getLevel(), e.getComments())).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
    
    private UserSkillDto toDto(UserSkillDbEntity e){
        if(e != null){
            return new UserSkillDto(e.getId(), e.getUserId(), e.getPhaseId(), e.getName(), e.getLevel(), e.getComments());
        }
        return null;
    }
    
    private UserSkillDbEntity fromDto(UserSkillDto dto){
        UserSkillDbEntity e = new UserSkillDbEntity();
        e.setId(dto.getId());
        e.setUserId(dto.getUserId());
        e.setPhaseId(dto.getPhaseId());
        e.setName(dto.getName());
        e.setLevel(dto.getLevel());
        e.setComments(dto.getComments());
        return e;
    }

}
