package com.nttdata.practicadevara.scoder.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.scoder.db.DBException;
import com.nttdata.practicadevara.scoder.db.User;
import com.nttdata.practicadevara.scoder.db.UserDbBean;
import com.nttdata.practicadevara.scoder.shared.dto.UserDto;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.ejb.EJB;

@Stateless
@LocalBean
public class UserBean {

    @EJB
    private UserDbBean userDbBean;
    
    public List<UserDto> list(){
        List<User> entities = userDbBean.findAll();
        return toDto(entities);
    }
    
    public List<UserDto> filterByNameAndAddrss(String name , String address){
        List<User> entities = userDbBean.filterByNameAndAddress(name , address);
        return toDto(entities);
    }
    
       public List<UserDto> filterByNameOrSurname(String name , String surname){
        List<User> entities = userDbBean.filterByNameOrSurname(name , surname);
        return toDto(entities);
    }
    
    public UserDto findById(Long id){
        User entity = userDbBean.findById(id);
        return toDto(entity);
    }
    
    public UserDto create(UserDto dto){
        User e = fromDto(dto);
        User entity = userDbBean.create(e);
        return toDto(entity);
    }
    
    public UserDto update(UserDto dto) throws DBException {
        User e = fromDto(dto);
        User entity = userDbBean.update(e);
        return toDto(entity);
    }
    
    private List<UserDto> toDto(List<User> list){
        if(list != null){
            return list.stream().map(e -> new UserDto(e.getId(), e.getname(), e.getsurname(), e.getaddress() , e.getphone() , e.getemail() , e.getfilename() , e.get_file() , e.getstate())).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
    
    private UserDto toDto(User e){
        if(e != null){
            return new UserDto(e.getId() , e.getname() , e.getsurname() , e.getaddress() , e.getphone() , e.getemail() , e.getfilename() , e.get_file() , e.getstate());
        }
        return null;
    }
    
    private User fromDto(UserDto dto){
        User e = new User();
        
        e.setname(dto.getname());
         e.setsurname(dto.getsurname());
          e.setaddress(dto.getaddress());
           e.setphone(dto.getphone());
            e.setemail(dto.getemail());
             e.setfilename(dto.getfilename());
              e.set_file(dto.get_file());
               e.setstate(dto.getstate());
        
        return e;
    }

}
