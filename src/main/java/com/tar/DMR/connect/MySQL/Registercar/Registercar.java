package com.tar.DMR.connect.MySQL.Registercar;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity

@Table(name = "register")
public class Registercar {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id", nullable = false)

    private Integer registerId;
    private Integer peopleId;
    private Integer carId;
    private String registerArea;
    private String registerCounty;
    private String startDate;
    private String endDate;


    // เป็นการ Join ตารางแบบรวดเร็ว
//    @OneToMany
    @OneToOne
    @JoinColumn(name = "peopleId", insertable = false, updatable = false)
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Employeecar employeecar;

    @Transient
    public String getDriverName() {
        return !isNull(employeecar) ? employeecar.getDriverFullName() : "";
    }

    @Transient
    public String getPhonNumber() {
        return !isNull(employeecar) ? employeecar.getPhoneNumber() : "";
    }

    @OneToOne
    @JoinColumn(name = "carId", insertable = false, updatable = false)
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Carregis carregis;

    @Transient
    public String getCarRegis() {
         return !isNull(carregis) ? carregis.getCarRegis() : "";
    }

}

