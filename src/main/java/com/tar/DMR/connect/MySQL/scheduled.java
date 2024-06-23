package com.tar.DMR.connect.MySQL;

import com.tar.DMR.connect.MySQL.Employeecar.Employeecar;
import com.tar.DMR.connect.MySQL.Employeecar.EmployeecarRepository;
import com.tar.DMR.connect.MySQL.Registercar.Registercar;
import com.tar.DMR.connect.MySQL.Registercar.RegistercarRepository;
import com.tar.DMR.connect.MySQL.Statuscar.Statuscar;
import com.tar.DMR.connect.MySQL.Statuscar.StatuscarService;
import com.tar.DMR.connect.MySQL.carregis.Carregis;
import com.tar.DMR.connect.MySQL.carregis.CarregisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import static java.util.Objects.isNull;

@Component
public class scheduled {

    @Autowired
    private RegistercarRepository registercarRepository;
    @Autowired
    private EmployeecarRepository employeecarRepository;
    @Autowired
    private CarregisRepository carregisRepository;
    @Autowired
    private StatuscarService statuscarService;



//    @Scheduled(fixedDelay = 5000)
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduledCheck() {
        System.out.println("cahekTime");
        List<Registercar> registercar = registercarRepository.findAll();
//        List<Employeecar> employeecar = employeecarRepository.findAll();
//        List<Carregis> carregis = carregisRepository.findAll();
//        System.out.println(registercar);


        registercar.forEach(data -> {
            Date currenDate = new Date();
            Date lastDate;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            try {
                lastDate = formatter.parse(data.getEndDate());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            if (currenDate.after(lastDate)) {

                // find data
                Employeecar employeecar = employeecarRepository.findById(data.getPeopleId()).orElse(null);
                if (!isNull(employeecar)) {
//                    employeecar.setDriverStatus(false);

                    // save data
                    employeecarRepository.save(employeecar);
                }

                // carregis
                Carregis carregis = carregisRepository.findById(data.getCarId()).orElse(null);
                if (!isNull(carregis)){
//                    carregis.setCarStatus(false);

                    carregisRepository.save(carregis);
                }

                Statuscar statuscar = statuscarService.findAllById(data.getPeopleId(),data.getCarId()).orElse(null);
                if (!isNull(statuscar)){
                  statuscar.setStatusCar(false);

                  statuscarService.save(statuscar);
                }
            }
        });
    }
}
