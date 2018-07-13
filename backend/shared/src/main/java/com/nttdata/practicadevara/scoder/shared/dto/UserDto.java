package com.nttdata.practicadevara.scoder.shared.dto;


/**
 *
 * @author bogdan.rebegel
 */
public class UserDto {
    
    private long id;

    private String name;

    private String surname;

    private String address;

    private int phone;

    private String email;

    private String filename;

    private String _file;

    private int state;

    public UserDto() {
    }
    
    public UserDto(long id, String name, String surname, String address, int phone, String email, String filename, String _file, int state) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.filename = filename;
        this._file = _file;
        this.state = state;
    }
 
//Setter & getter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
   
    
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getsurname() {
        return surname;
    }

    public void setsurname(String surname) {
        this.surname = surname;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
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

    public String get_file() {
        return _file;
    }

    public void set_file(String _file) {
        this._file = _file;
    }

    public int getstate() {
        return state;
    }

    public void setstate(int state) {
        this.state = state;
    }

}
