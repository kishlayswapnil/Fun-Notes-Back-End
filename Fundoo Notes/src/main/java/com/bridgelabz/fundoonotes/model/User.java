package com.bridgelabz.fundoonotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//A Database class for user information.
@Entity
@Table(name = "UserData")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    //Variables.
    //Adding Id as primary key.
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private long mobileNumber;
    private String password;
    private LocalDateTime registrationDate;
    private LocalDateTime modifiedDate;
    private boolean isVerified;

    // collaborator for notes
    @JsonIgnore
    @ManyToMany(mappedBy = "collaboratedUsers")
    private List<Note> collaboratedNotes;

    //An empty constructor.
    public User() {
    }

    //A parameterised constructor.
    public User(int id, String firstName, String lastName, String emailId, long mobileNumber, String password, LocalDateTime registrationDate, LocalDateTime modifiedDate, boolean isVerified) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.registrationDate = registrationDate;
        this.modifiedDate = modifiedDate;
        this.isVerified = isVerified;
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

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public List<Note> getCollaboratedNotes() {
        return collaboratedNotes;
    }
    public void setCollaboratedNotes(List<Note> collaboratedNotes) {
        this.collaboratedNotes = collaboratedNotes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", modifiedDate=" + modifiedDate +
                ", isVerified=" + isVerified +
                '}';
    }
}
