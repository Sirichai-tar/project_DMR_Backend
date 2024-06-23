package com.tar.DMR.connect.MySQL.Employeecar;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "employeecar" )
public class Employeecar {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "people_id", nullable = false)

    private Integer peopleId;
    private String phoneNumber;
    private String driverName;
    private String driverLastname;
    private byte[] peopleImg;
//    private Boolean driverStatus;

    @Transient
    private String peopleshowImg;

    @Transient
    public String getDriverFullName() {
        return this.driverName + " " + this.driverLastname;
    }
}
