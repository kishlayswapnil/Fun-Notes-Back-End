package com.bridgelabz.fundoonotes.dto;

import javax.validation.constraints.Email;

//A POJO class for login data.
public class LoginDto {

    //Variables.
    @Email
    private String emailId;
    private String password;

    //Getters and setters.
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
