package com.nttdata.practicadevara.scoder.ejb;

import com.nttdata.practicadevara.scoder.db.AppConfigDbEntity;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.scoder.shared.dto.UserPhaseResultDto;
import com.nttdata.practicadevara.scoder.db.UserPhaseResultDbEntity;
import com.nttdata.practicadevara.scoder.db.UserPhaseResultDbBean;
import com.nttdata.practicadevara.scoder.db.DBException;
import com.nttdata.practicadevara.scoder.shared.dto.AppConfigDto;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import javax.ejb.EJB;

@Stateless
@LocalBean
public class UserPhaseResultBean {

    @EJB
    private UserPhaseResultDbBean userPhaseResultDbBean;
    
    public List<UserPhaseResultDto> list(){
        List<UserPhaseResultDbEntity> entities = userPhaseResultDbBean.findAll();
        return toDto(entities);
    }
    
     public List<UserPhaseResultDto> filter(String sfilter){
        List<UserPhaseResultDbEntity> entities = userPhaseResultDbBean.filter(sfilter);
        return toDto(entities);
    }
    
//    public List<UserPhaseResultDto> findByDate(Date date){
//        List<UserPhaseResultDbEntity> entity = userPhaseResultDbBean.filterByDate(date);
//        return toDto(entity);
//    }
//    
//    public List<UserPhaseResultDto> findByUserId(Long userId){
//        List<UserPhaseResultDbEntity> entity = userPhaseResultDbBean.filterByUserId(userId);
//        return toDto(entity);
//    }
//    
//    public List<UserPhaseResultDto> findByPhaseId(Long phaseId){
//        List<UserPhaseResultDbEntity> entity = userPhaseResultDbBean.filterByPhaseId(phaseId);
//        return toDto(entity);
//    }
//    
//     public List<UserPhaseResultDto> findByRank(double rank){
//        List<UserPhaseResultDbEntity> entity = userPhaseResultDbBean.filterByRank(rank);
//        return toDto(entity);
//    }
    
     public List<UserPhaseResultDto> findByPassed(boolean pass){
        List<UserPhaseResultDbEntity> entity = userPhaseResultDbBean.filterByPassed(pass);
        return toDto(entity);
    }
     
    public UserPhaseResultDto create(UserPhaseResultDto dto){
        UserPhaseResultDbEntity e = fromDto(dto);
        UserPhaseResultDbEntity entity = userPhaseResultDbBean.create(e);
        return toDto(entity);
    }
    
    public UserPhaseResultDto update(UserPhaseResultDto dto) throws DBException {
        UserPhaseResultDbEntity e = fromDto(dto);
        UserPhaseResultDbEntity entity = userPhaseResultDbBean.update(e);
        return toDto(entity);
    }
    
    private List<UserPhaseResultDto> toDto(List<UserPhaseResultDbEntity> list){
        if(list != null){
            return list.stream().map(e -> new UserPhaseResultDto(e.getId(), e.getDate(), e.getUserId(), e.getPhaseId(), e.getComments(), e.getRanking(), e.getPassed())).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
    
    private UserPhaseResultDto toDto(UserPhaseResultDbEntity e){
        if(e != null){
            return new UserPhaseResultDto(e.getId(), e.getDate(), e.getUserId(), e.getPhaseId(), e.getComments(), e.getRanking(), e.getPassed());
        }
        return null;
    }
    
    private UserPhaseResultDbEntity fromDto(UserPhaseResultDto dto){
        UserPhaseResultDbEntity e = new UserPhaseResultDbEntity();
        e.setId(dto.getId());
        e.setDate(dto.getDate());
        e.setUserId(dto.getUserId());
        e.setPhaseId(dto.getPhaseId());
        e.setComments(dto.getComments());
        e.setRanking(dto.getRanking());
        e.setPassed(dto.getPassed());
        return e;
    }

}
