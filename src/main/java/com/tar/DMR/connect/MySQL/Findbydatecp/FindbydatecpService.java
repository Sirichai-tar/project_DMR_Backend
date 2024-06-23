package com.tar.DMR.connect.MySQL.Findbydatecp;

import com.tar.DMR.connect.MySQL.Employeecar.Employeecar;
import com.tar.DMR.connect.MySQL.Employeecar.EmployeecarRepository;
import com.tar.DMR.connect.MySQL.Registercar.Registercar;

import com.tar.DMR.connect.MySQL.Registercar.RegistercarRepository;
import com.tar.DMR.connect.MySQL.carregis.Carregis;
import com.tar.DMR.connect.MySQL.carregis.CarregisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FindbydatecpService {


    @Autowired
    private  FindbydatecpRepository findbydatecpRepository;
    private  CarregisRepository carregisRepository;
    private  EmployeecarRepository employeecarRepository;

    private RegistercarRepository registercarRepository;

    public List<Findbydatecp> findBydate() {
        List<Findbydatecp> findbydatecpList = new ArrayList<>();
//        List<Carregis> carregisList = carregisRepository.findAll();
//        List<Employeecar> employeecarList = employeecarRepository.findAll();
        List<Registercar> registercarList = findbydatecpRepository.findBydate();

        if (registercarList != null){
            findbydatecpList.forEach(d ->{
                registercarList.forEach(r -> {
                    if (r.getStartDate().equals(d.getStartDate()) && r.getEndDate().equals(d.getEndDate())){
                        d.setCarRegis(r.getCarRegis());
                        d.setDriverName(r.getDriverName());
                        d.setCarId(r.getCarId());
                        d.setProploId(r.getPeopleId());
                    }
                });
            });
        }
        return findbydatecpList;
    }


}
