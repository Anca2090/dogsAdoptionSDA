package org.example.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "reservations")
public class ReservationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    private Timestamp reservationDate;

    private Boolean canceled;

    private Boolean deleted;

//    @ManyToMany(mappedBy = "reservations")
//    private List<AdoptersEntity> adoptersEntityList;
//
//    @ManyToMany(mappedBy = "reservationsForDogs")
//    private List<DogsEntity> dogs;

}
