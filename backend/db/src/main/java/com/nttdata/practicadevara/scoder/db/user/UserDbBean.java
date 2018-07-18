package com.nttdata.practicadevara.scoder.db.user;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.DBException;
import java.util.ArrayList;
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
        mergeUserPhaseResult(entity.getPhaseResults(), e.getPhaseResults());
        return super.update(entity);
    }

    private void mergeUserPhaseResult(List<UserPhaseResultDbEntity> dataInDb, List<UserPhaseResultDbEntity> newData) {
        if(dataInDb == null) {
           dataInDb = new ArrayList<>();
        }
        if(newData == null) {
           newData = new ArrayList<>();
        }
        List<UserPhaseResultDbEntity> toDelete = new ArrayList<>();
        List<UserPhaseResultDbEntity> toCreate = new ArrayList<>();
        List<UserPhaseResultDbEntity> toUpdate = new ArrayList<>();
        for (UserPhaseResultDbEntity e : dataInDb) {
            if (find(newData, e.getId()) == null) {
                toDelete.add(e);
            } else {
                toUpdate.add(e);
            }
        }
        for (UserPhaseResultDbEntity e : newData) {
            if (find(dataInDb, e.getId()) == null) {
                toCreate.add(e);
            }
        }
        for (UserPhaseResultDbEntity e : toDelete) {
            dataInDb.remove(e);
        }
        for (UserPhaseResultDbEntity e : toUpdate) {
            copy(e, find(newData, e.getId()));
        }
        for (UserPhaseResultDbEntity e : toCreate) {
            //super.create(e);
            dataInDb.add(e);
        }
    }

    private void copy(UserPhaseResultDbEntity dest, UserPhaseResultDbEntity src) {
        dest.setComments(src.getComments());
        dest.setDate(src.getDate());
        dest.setPassed(src.getPassed());
        dest.setPhaseId(src.getPhaseId());
        dest.setRanking(src.getRanking());
    }

    private UserPhaseResultDbEntity find(List<UserPhaseResultDbEntity> entities, Long id) {
        if (id != null && entities != null) {
            for (UserPhaseResultDbEntity e : entities) {
                if (id.equals(e.getId())) {
                    return e;
                }
            }
        }
        return null;
    }
}
