package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "adopters")
public class AdoptersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adopterId;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;


    @OneToMany(mappedBy = "adoptersEntity")
    private List<DogsEntity> dogsList;


    public UserTypes getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(UserTypes userTypes) {
        this.userTypes = userTypes;
    }

//    @ManyToMany
//    @JoinTable(
//            name = "adopters_reservations",
//            joinColumns = {@JoinColumn(name = "adopterId")},
//            inverseJoinColumns = {@JoinColumn(name = "reservationId")}
//    )
//    private List<ReservationsEntity> reservations;

//    @ManyToMany
//    @JoinTable(
//            name="adopters_adoptions",
//            joinColumns = {@JoinColumn(name="adopterId")},
//            inverseJoinColumns = {@JoinColumn(name="adoptionId")}
//    )
//    private List<AdoptionsEntity> adoptions;

    @OneToMany(mappedBy="adopter")
    private List<AdoptionsEntity> adoptions;

    @OneToOne
    @JoinColumn(name="username")
    private User user;


    @OneToOne
    @JoinColumn(name="userTypeId")
    private UserTypes userTypes;

    public List<AdoptionsEntity> getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(List<AdoptionsEntity> adoptions) {
        this.adoptions = adoptions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DogsEntity> getDogsList() {
        return dogsList;
    }

    public void setDogsList(List<DogsEntity> dogsList) {
        this.dogsList = dogsList;
    }

//    public List<ReservationsEntity> getReservations() {
//        return reservations;
//    }
//
//    public void setReservations(List<ReservationsEntity> reservations) {
//        this.reservations = reservations;
//    }

    public AdoptersEntity() {
    }

    public Integer getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Integer adopterId) {
        this.adopterId = adopterId;
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
    
}
