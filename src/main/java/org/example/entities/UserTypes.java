package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_types")
public class UserTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userTypeId;

    private String userTypeName;

    public UserTypes() {
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
