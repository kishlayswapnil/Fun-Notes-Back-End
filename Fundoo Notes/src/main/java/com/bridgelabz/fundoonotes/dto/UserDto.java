package com.bridgelabz.fundoonotes.dto;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

//A POJO class for user.
@XmlRootElement
@Entity
public class UserDto {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int mobileNumber;
    private String password;

    //An empty constructor.
    public UserDto() {
    }

    //A parameterised constructor.
    public UserDto(int id, String firstName, String lastName, String emailId, int mobileNumber, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    //Getters and setters for following variables.
    @javax.persistence.Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
