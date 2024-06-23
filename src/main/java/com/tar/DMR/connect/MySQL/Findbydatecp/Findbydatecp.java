package com.tar.DMR.connect.MySQL.Findbydatecp;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.Nulls;
import com.tar.DMR.connect.MySQL.Employeecar.Employeecar;
import com.tar.DMR.connect.MySQL.carregis.Carregis;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import static java.util.Objects.isNull;

@NoArgsConstructor
@Data
@Entity(name = "Findbydatecp")
@Table(name = "register")
public class Findbydatecp {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_Id" , nullable = false)
    private  Integer carId;
    private  Integer proploId;
    private String carRegis;
    private String startDate;
    private String endDate;
    private  String driverName;
    private String driverLastname;

    @OneToOne
    @JoinColumn(name = "carId" ,insertable = false , updatable = false)
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Carregis carregis;

    @Transient
    public String getCarRegis(){return !isNull(carregis) ? carregis.getCarRegis() : "";}


    @OneToOne
    @JoinColumn(name = "proploId" ,insertable = false , updatable = false)
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Employeecar employeecar;

    @Transient
    public String getdriverName(){return !isNull(employeecar) ? employeecar.getDriverFullName(): "";}
}