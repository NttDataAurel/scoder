package com.nttdata.practicadevara.scoder.db;

import com.mysql.cj.jdbc.Blob;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name = User.TBL_APP_CONFIG, schema = AbstractBean.SCHEMA_NAME)
@NamedQueries({
       
        @NamedQuery(name = User.FIND_ALL, query = "SELECT e FROM User e"),
        @NamedQuery(name = User.FIND_BY_ID, query = "SELECT e FROM User e WHERE e.id=:"+ AbstractBean.ID_PARAM),
        @NamedQuery(name = User.FILTER_BY_name, query = "SELECT e FROM User e WHERE e.name like:"+ User.FILTER_BY_name)
        
        
})
public class User extends AbstractEntity implements Serializable {
    
    private static final long serialVersionUID = 117223295272084434L;
    
    public static final String FIND_ALL = "FIND_ALL_JPQL";
    public static final String FIND_BY_ID = "FIND_BY_ID_JPQL";
    public static final String TBL_APP_CONFIG = "app_config";
    public static final String FILTER_BY_name = "FILTER_BY_name";
    
    
    
    //Columns
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "SURNAME")
    private String SURNAME;
    
     @Column(name = "ADR")
    private String ADR;

     
      @Column(name = "phone")
    private int phone;

      
       @Column(name = "email")
    private String email;

       
        @Column(name = "filename")
    private String filename;

        
         @Column(name = "_file")
    private Blob _file;

         
          @Column(name = "state")
    private int state;

//Setter & getter
          
          
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }
    
    public String getADR() {
        return ADR;
    }
    
     public void setADR(String ADR) {
        this.ADR = ADR;
    }
     
      public int getphone() {
        return phone;
    }
    
     public void setphone(int phone) {
        this.phone = phone;
    }
     
      public String getemail() {
        return email;
    }
    
     public void setemail(String email) {
        this.email = email;
    }
     
        public String getfilename() {
        return filename;
    }
    
     public void setfilename(String filename) {
        this.filename = filename;
    }
     
           public Blob get_file() {
        return _file;
    }
    
     public void set_file(Blob _file) {
        this._file = _file;
    }
     
     public int getstate() {
        return state;
    }
    
     public void set_file(int state) {
        this.state = state;
    }
     
     
     
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppConfigDbEntity)) {
            return false;
        }
        User other = (User) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+" [ id=" + getId() + " ]";
    }
}
