package com.tar.DMR.connect.MySQL.carregis;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@NoArgsConstructor
@Data
@Entity(name = "carregis")
//@Builder
public class Carregis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id" , nullable = false)
    private Integer carId;

    private String carRegis;

    private String carType;

    private String carNature ;

//    private Boolean carStatus;

    private byte[] carImg;

    @Transient
    private String carshowImg;
}

