package com.tar.DMR.connect.MySQL.Registercar;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TableRegistercar {
    private  Integer carId;
    private  Integer proploId;
    private String carRegis;
    private String driverName;
    private String startDate;
    private String endDate;
    private String phonNumber;
    private Boolean carStatus;
    private Boolean statusCar;
}
