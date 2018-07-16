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

    private String file;

    private int state;

    public UserDto() {
    }
    
    public UserDto(long id, String name, String surname, String address, int phone, String email, String filename, String file, int state) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.filename = filename;
        this.file = file;
        this.state = state;
    }
 
//Setter & getter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
