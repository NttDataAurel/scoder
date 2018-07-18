package com.nttdata.practicadevara.scoder.db.user;

import com.nttdata.practicadevara.scoder.db.AbstractBean;
import com.nttdata.practicadevara.scoder.db.AbstractEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = UserDbEntity.TBL_USER, schema = AbstractBean.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = UserDbEntity.FIND_ALL, query = "SELECT e FROM UserDbEntity e")
    ,@NamedQuery(name = UserDbEntity.FIND_BY_ID, query = "SELECT e FROM UserDbEntity e WHERE e.id = :" + AbstractBean.ID_PARAM)
    ,@NamedQuery(name = UserDbEntity.FILTER_BY_NAME_AND_ADDRESS, query = "SELECT e FROM UserDbEntity e WHERE "
               + "( e.name like :" + UserDbEntity.PARAM_NAME + " or e.surname like :" + UserDbEntity.PARAM_SURNAME + ") "
               + " and e.address like :" + UserDbEntity.PARAM_ADDRESS)
    ,@NamedQuery(name = UserDbEntity.FILTER_BY_NAME_OR_SURNAME, query = "SELECT e FROM UserDbEntity e WHERE e.name like :" + UserDbEntity.PARAM_NAME + " or e.surname like :" + UserDbEntity.PARAM_SURNAME)
})
public class UserDbEntity extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 117223295272084434L;

    public static final String FIND_ALL = "USER_FIND_ALL_JPQL";
    public static final String FIND_BY_ID = "USER_FIND_BY_ID_JPQL";
    public static final String TBL_USER = "user";
    public static final String PARAM_NAME = "param_name";
    public static final String PARAM_ADDRESS = "param_address";
    public static final String PARAM_SURNAME = "param_surname";

    public static final String FILTER_BY_NAME_AND_ADDRESS = "USER_FILTER_BY_NAME_AND_ADDRESS";
    public static final String FILTER_BY_NAME_OR_SURNAME = "USER_FILTER_BY_NAME_OR_SURNAME";

    //Columns
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "filename")
    private String filename;

    @Lob
    @Column(name = "filedata")
    private byte[] fileData;

    @Column(name = "state")
    private int state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
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
        if (!(object instanceof UserDbEntity)) {
            return false;
        }
        UserDbEntity other = (UserDbEntity) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " [ id=" + getId() + " ]";
    }
}
