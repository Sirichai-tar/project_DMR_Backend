package com.tar.DMR.connect.MySQL.Statuscar;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "statuscar")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Statuscar {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false)
    private Integer statusId;

    private Integer carId;

    private Integer peopleId;

    private Boolean statusCar;
}
