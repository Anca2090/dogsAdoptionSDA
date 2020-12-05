package org.example.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "dogs")
public class DogsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dogId;
    private Integer dogNumber;
    private String name;
    private String age;
    private String sex;
    @Column(length = 700)
    private String description;
    private String imageUrl;
    private Timestamp registrationDate;

    private Boolean adopted;
    private Boolean deleted;

    public Integer getDogNumber() {
        return dogNumber;
    }

    public void setDogNumber(Integer dogNumber) {
        this.dogNumber = dogNumber;
    }


    @ManyToOne
    @JoinColumn(name="adopterId")
    private AdoptersEntity adoptersEntity;

    @OneToMany(mappedBy = "dog")
    private List<AdoptionsEntity> adoptionsList;

    public AdoptersEntity getAdoptersEntity() {
        return adoptersEntity;
    }

    public void setAdoptersEntity(AdoptersEntity adoptersEntity) {
        this.adoptersEntity = adoptersEntity;
    }

    public List<AdoptionsEntity> getAdoptionsList() {
        return adoptionsList;
    }

    public void setAdoptionsList(List<AdoptionsEntity> adoptionsList) {
        this.adoptionsList = adoptionsList;
    }

    public DogsEntity() {
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }


    public Boolean getAdopted() {
        return adopted;
    }

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}
