package com.tar.DMR.connect.MySQL.Employeecar;


import com.tar.DMR.connect.MySQL.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeecarService {


    @Autowired
    private EmployeecarRepository employeecarRepository;

    public Employeecar save(Employeecar employeecar) {
     byte[] imagebytes = ImageUtils.stringToByte(employeecar.getPeopleshowImg());
     employeecar.setPeopleImg(imagebytes);
     System.out.print(employeecar);
        return employeecarRepository.save(employeecar);
    }

    public List<Employeecar> findAll() {
        List<Employeecar> employeecars = employeecarRepository.findAll();

        employeecars.forEach(data ->{
            String bast64 = ImageUtils.byteToString(data.getPeopleImg());
            data.setPeopleshowImg(bast64);
        });
        return employeecars;
    }

    public void deleteById(Integer peopleId) {
        employeecarRepository.deleteById(peopleId);
    }

    public List<Employeecar> saveAll(List<Employeecar> employeecarList) { return employeecarRepository.saveAll(employeecarList);
    }

    public Employeecar findByDriverNameAndLastName(String driveName, String driverLastname) {
        return employeecarRepository.findByDriverNameAndLastName(driveName,driverLastname);
    }

    public Optional<Employeecar> findById(Integer peopleId) {
        return employeecarRepository.findById(peopleId);
    }
}
