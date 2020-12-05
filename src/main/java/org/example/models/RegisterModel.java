package org.example.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RegisterModel {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private Integer userTypeId;
    private Timestamp adoptionDate;
    private Boolean deleted;

    private String authority;
    private List<Integer> reservations;
    private List<Integer> adoptions;


    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public List<Integer> getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(List<Integer> adoptions) {
        this.adoptions = adoptions;
    }



    public RegisterModel() {
        reservations = new ArrayList<>();
        adoptions = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Timestamp adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<Integer> getReservations() {
        return reservations;
    }

    public void setReservations(List<Integer> reservations) {
        this.reservations = reservations;
    }
}
