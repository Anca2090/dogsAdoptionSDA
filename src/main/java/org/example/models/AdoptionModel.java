package org.example.models;

public class AdoptionModel {

    private Integer adopterId;
    private Integer dogNumber;
    private String adoptionDate;

    public AdoptionModel() {
    }

    public Integer getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Integer adopterId) {
        this.adopterId = adopterId;
    }

    public Integer getDogNumber() {
        return dogNumber;
    }

    public void setDogNumber(Integer dogNumber) {
        this.dogNumber = dogNumber;
    }

    public String getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(String adoptionDate) {
        this.adoptionDate = adoptionDate;
    }
}
