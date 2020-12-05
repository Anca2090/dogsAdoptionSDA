package org.example.entities;

import com.mysql.cj.xdevapi.TableImpl;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="adoptions")
public class AdoptionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adoptionId;

    private Timestamp adoptionDate;

    private Boolean deleted;

    private Boolean canceled;

    @ManyToOne
    @JoinColumn(name = "adopter")
    private AdoptersEntity adopter;

    @ManyToOne
    @JoinColumn(name="dog")
    private DogsEntity dog;

    public DogsEntity getDog() {
        return dog;
    }

    public void setDog(DogsEntity dog) {
        this.dog = dog;
    }

    public Integer getAdoptionId() {
        return adoptionId;
    }

    public void setAdoptionId(Integer adoptionId) {
        this.adoptionId = adoptionId;
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

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public AdoptersEntity getAdopter() {
        return adopter;
    }

    public void setAdopter(AdoptersEntity adopter) {
        this.adopter = adopter;
    }
}
