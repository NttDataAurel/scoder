package com.nttdata.practicadevara.scoder.db;

import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UserDbBean extends AbstractBean<User>{
    @Override
    public String findAllNamedQuery(){
        return User.FIND_ALL;
    }

    @Override
    public String findByIdNamedQuery(){
        return User.FIND_BY_ID;
    }
    

    
   
    
    public List<User> filterByNameAndAddrsss(String name, String address) {
        String paramName = "%"+name+"%";
        String paramAddrss = "%"+address+"%";
        return manager.createNamedQuery(User.FILTER_BY_NAME_AND_ADDRESS)
                .setParameter(User.PARAM_NAME, paramName)
                .setParameter(User.PARAM_ADDRESS, paramAddrss)
                .getResultList();
    }
    
 public List<User> filterByNameOrSurname(String name, String surname) {
        String paramName = "%"+name+"%";
        String paramSurname = "%"+surname+"%";
        return manager.createNamedQuery(User.FILTER_BY_NAME_OR_SURNAME)
                .setParameter(User.PARAM_NAME, paramName)
                .setParameter(User.PARAM_SURNAME, paramSurname)
                .getResultList();
    }
    
    public User update(User e) throws DBException {
        if(e == null){
            throw new DBException("Cannot update entity");
        }
        if(e.getId() == null){
            throw new DBException("Cannot update entity without id");
        }
        User entity = findById(e.getId());
        entity.setname(e.getname());
        
        return super.update(entity);
    }

}
