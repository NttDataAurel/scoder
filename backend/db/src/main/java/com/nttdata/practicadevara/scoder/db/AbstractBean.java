package com.nttdata.practicadevara.scoder.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractBean<T extends AbstractEntity> {
    public static final String SCHEMA_NAME = "scoderdb";
    public static final String ID_PARAM = "id_param";

    @PersistenceContext(unitName = "scoder-persistenceunit")
    //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public T create(T entity) {
        createWithoutFlush(entity);
        manager.flush();
        return entity;
    }

    public T update(T entity) throws DBException {
        checkExistance(entity);
        return updateWithoutExistanceCheck(entity);
    }

    protected T updateWithoutExistanceCheck(T entity) {
        entity = manager.merge(entity);
        return entity;
    }

    protected T createWithoutFlush(T entity) {
        manager.persist(entity);
        return entity;
    }

    protected void flushClear() {
        manager.flush();
        manager.clear();
    }

    public void delete(Long id) throws DBException {
        T entity = findById(id);
        if (entity != null) {
            manager.remove(entity);
        }
    }

    public void delete(T e) throws DBException {
        T entity = checkExistance(e);
        manager.remove(manager.merge(entity));
    }

    public List<T> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }

    public T findById(Long id) {
        return (T) manager
                .createNamedQuery(findByIdNamedQuery())
                .setParameter(ID_PARAM, id)
                .getSingleResult();
    }

    private T checkExistance(T entity) throws DBException {
        if (entity == null) {
            throw new DBException("Entity not found");
        }
        T object = findById(entity.getId());
        if (object == null) {
            throw new DBException("Entity not found");
        }
        return object;
    }

    public abstract String findAllNamedQuery();

    public abstract String findByIdNamedQuery();

}
