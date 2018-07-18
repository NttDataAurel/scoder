package com.nttdata.practicadevara.scoder.db.user;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.DBException;
import com.nttdata.practicadevara.scoder.db.phase.PhaseDbEntity;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UserDbBean extends AbstractBean<UserDbEntity> {

    @Override
    public String findAllNamedQuery() {
        return UserDbEntity.FIND_ALL;
    }

    @Override
    public String findByIdNamedQuery() {
        return UserDbEntity.FIND_BY_ID;
    }

    public List<UserDbEntity> filterByNameAndAddress(String name, String address) {
        String paramName = "%" + name + "%";
        String paramAddress = "%" + address + "%";
        return manager.createNamedQuery(UserDbEntity.FILTER_BY_NAME_AND_ADDRESS)
                .setParameter(UserDbEntity.PARAM_NAME, paramName)
                .setParameter(UserDbEntity.PARAM_SURNAME, paramName)
                .setParameter(UserDbEntity.PARAM_ADDRESS, paramAddress)
                .getResultList();
    }

    public List<UserDbEntity> filterByNameOrSurname(String name, String surname) {
        String paramName = "%" + name + "%";
        String paramSurname = "%" + surname + "%";
        return manager.createNamedQuery(UserDbEntity.FILTER_BY_NAME_OR_SURNAME)
                .setParameter(UserDbEntity.PARAM_NAME, paramName)
                .setParameter(UserDbEntity.PARAM_SURNAME, paramSurname)
                .getResultList();
    }

    @Override
    public UserDbEntity update(UserDbEntity e) throws DBException {
        if (e == null) {
            throw new DBException("Cannot update entity");
        }
        if (e.getId() == null) {
            throw new DBException("Cannot update entity without id");
        }
        UserDbEntity entity = findById(e.getId());
        entity.setName(e.getName());
        entity.setSurname(e.getSurname());
        entity.setAddress(e.getAddress());
        entity.setPhone(e.getPhone());
        entity.setEmail(e.getEmail());
        entity.setFilename(e.getFilename());
        entity.setState(e.getState());
        return super.update(entity);
    }
    public void delete(String name,String address) throws DBException {
        List<UserDbEntity> entity = filterByNameAndAddress(name,address);
        if (entity != null) {
            manager.remove(entity);
        }
    }

}
