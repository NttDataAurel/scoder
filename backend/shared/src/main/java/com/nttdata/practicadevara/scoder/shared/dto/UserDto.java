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

    private String phone;

    private String email;

    private String fileName;

    private byte[] fileData;

    private int state;

    public UserDto() {
    }
    
    public UserDto(long id, String name, String surname, String address, String phone, String email, String fileName, byte[] fileData, int state) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fileName = fileName;
        this.fileData = fileData;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

}
