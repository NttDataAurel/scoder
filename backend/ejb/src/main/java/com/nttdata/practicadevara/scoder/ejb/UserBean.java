package com.nttdata.practicadevara.scoder.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.scoder.db.DBException;
import com.nttdata.practicadevara.scoder.db.user.UserDbEntity;
import com.nttdata.practicadevara.scoder.db.user.UserDbBean;
import com.nttdata.practicadevara.scoder.db.user.UserPhaseResultDbEntity;
import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import com.nttdata.practicadevara.scoder.shared.dto.UserPhaseResultDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.ejb.EJB;

@Stateless
@LocalBean
public class UserBean {

    @EJB
    private UserDbBean userDbBean;

    public List<UserDto> list() {
        List<UserDbEntity> entities = userDbBean.findAll();
        return toDto(entities);
    }

    public List<UserDto> filterByNameAndAddress(String name, String address) {
        List<UserDbEntity> entities = userDbBean.filterByNameAndAddress(name, address);
        return toDto(entities);
    }

    public List<UserDto> filterByNameOrSurname(String name, String surname) {
        List<UserDbEntity> entities = userDbBean.filterByNameOrSurname(name, surname);
        return toDto(entities);
    }

    public UserDto findById(Long id) {
        UserDbEntity entity = userDbBean.findById(id);
        return toDto(entity);
    }

    public UserDto create(UserDto dto) {
        UserDbEntity e = fromDto(dto);
        UserDbEntity entity = userDbBean.create(e);
        return toDto(entity);
    }

    public UserDto update(UserDto dto) throws DBException {
        UserDbEntity e = fromDto(dto);
        UserDbEntity entity = userDbBean.update(e);
        return toDto(entity);
    }

    private List<UserDto> toDto(List<UserDbEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    private UserDto toDto(UserDbEntity e) {
        UserDto usrDto = null;
        if (e != null) {
            usrDto = new UserDto(e.getId(), e.getName(), e.getSurname(), e.getAddress(), e.getPhone(), e.getEmail(), e.getFilename(), e.getFileData(), e.getState());
            if (e.getPhaseResults() != null && !e.getPhaseResults().isEmpty()) {
                List<UserPhaseResultDto> dtoList = e.getPhaseResults().stream().map(phaseResult -> toDto(phaseResult)).collect(Collectors.toList());
                usrDto.setPhaseResults(dtoList);
            }
        }
        return usrDto;
    }

    private UserPhaseResultDto toDto(UserPhaseResultDbEntity e) {
        return new UserPhaseResultDto(e.getId(), e.getDate(), e.getPhaseId(), e.getComments(), e.getRanking(), e.getPassed());
    }

    private UserDbEntity fromDto(UserDto dto) {
        UserDbEntity e = new UserDbEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setSurname(dto.getSurname());
        e.setAddress(dto.getAddress());
        e.setPhone(dto.getPhone());
        e.setEmail(dto.getEmail());
        e.setFilename(dto.getFileName());
        e.setState(dto.getState());
        if (dto.getPhaseResults() != null) {
            int size = dto.getPhaseResults().size();
            e.setPhaseResults(new ArrayList<>(size));
            for (UserPhaseResultDto d : dto.getPhaseResults()) {
                UserPhaseResultDbEntity ue = fromDto(d, e);
                e.getPhaseResults().add(ue);
            }
        }

        return e;
    }

    private UserPhaseResultDbEntity fromDto(UserPhaseResultDto dto, UserDbEntity user) {
        UserPhaseResultDbEntity e = new UserPhaseResultDbEntity();
        e.setId(dto.getId());
        e.setDate(dto.getDate());
        e.setUser(user);
        e.setPhaseId(dto.getPhaseId());
        e.setComments(dto.getComments());
        e.setRanking(dto.getRanking());
        e.setPassed(dto.getPassed());
        return e;
    }
}
