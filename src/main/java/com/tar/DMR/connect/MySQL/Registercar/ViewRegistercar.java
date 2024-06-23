package com.tar.DMR.connect.MySQL.Registercar;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViewRegistercar {
    private String carRegis;
    private String driverName;
    private String carNature;
    private String carType;
    private String phoneNumber;
}