package com.tar.DMR.connect.MySQL.Reservationcar;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "informationcar")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservationcar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id" , nullable = false)

    private Integer reservationId;
    private String driverName;
    private String driverLastname;
    private String carRegistration;
    private Integer phoneNumber;
    private String startDate;
    private String endDate;

}



