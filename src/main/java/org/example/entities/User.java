package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username", length = 20)
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean deleted;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public AdoptersEntity getAdoptersEntity() {
        return adoptersEntity;
    }

    public void setAdoptersEntity(AdoptersEntity adoptersEntity) {
        this.adoptersEntity = adoptersEntity;
    }

    @OneToOne(mappedBy = "user")
    private AdoptersEntity adoptersEntity;

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}