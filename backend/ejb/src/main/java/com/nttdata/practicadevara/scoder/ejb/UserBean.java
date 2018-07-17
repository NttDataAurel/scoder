package com.nttdata.practicadevara.scoder.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.scoder.db.DBException;
import com.nttdata.practicadevara.scoder.db.User;
import com.nttdata.practicadevara.scoder.db.UserDbBean;
import com.nttdata.practicadevara.scoder.db.UserPhaseResultDbEntity;
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
        List<User> entities = userDbBean.findAll();
        return toDto(entities);
    }

    public List<UserDto> filterByNameAndAddress(String name, String address) {
        List<User> entities = userDbBean.filterByNameAndAddress(name, address);
        return toDto(entities);
    }

    public List<UserDto> filterByNameOrSurname(String name, String surname) {
        List<User> entities = userDbBean.filterByNameOrSurname(name, surname);
        return toDto(entities);
    }

    public UserDto findById(Long userId) {
        User entity = userDbBean.findById(userId);
        return toDto(entity);
    }

    public UserDto create(UserDto dto) {
        User e = fromDto(dto);
        User entity = userDbBean.create(e);
        return toDto(entity);
    }

    public UserDto update(UserDto dto) throws DBException {
        User e = fromDto(dto);
        User entity = userDbBean.update(e);
        return toDto(entity);
    }

    private List<UserDto> toDto(List<User> list) {
        if (list != null) {
            return list.stream().map(e -> new UserDto(e.getId(), e.getname(), e.getsurname(), e.getaddress(), e.getphone(), e.getemail(), e.getfilename(), e.get_file(), e.getstate())).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    private UserDto toDto(User e) {
        if (e != null) {
            return new UserDto(e.getId(), e.getname(), e.getsurname(), e.getaddress(), e.getphone(), e.getemail(), e.getfilename(), e.get_file(), e.getstate());
        }
        return null;
    }

    private User fromDto(UserDto dto) {
        User e = new User();

        e.setId(dto.getId());
        e.setname(dto.getName());
        e.setsurname(dto.getSurname());
        e.setaddress(dto.getAddress());
        e.setphone(dto.getPhone());
        e.setemail(dto.getEmail());
        e.setfilename(dto.getFilename());
        e.set_file(dto.getFile());
        e.setstate(dto.getState());

        if (dto.getPhaseResults() != null) {
            int size = dto.getPhaseResults().size();
            e.setPhaseResults(new ArrayList<UserPhaseResultDbEntity>(size));
            for (UserPhaseResultDto d : dto.getPhaseResults()) {
                UserPhaseResultDbEntity ue = fromDto(d);
                e.getPhaseResults().add(ue);
            }
        }

        return e;
    }

    private UserPhaseResultDbEntity fromDto(UserPhaseResultDto dto) {
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
