package com.bridgelabz.fundoonotes.dto;

public class ForgotDto {

    //Variables
    private String newPassword;

    private String email;

    //Getters and Setters.
    public String getPassword() {
        return newPassword;
    }

    public void setPassword(String password) {
        this.newPassword = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
