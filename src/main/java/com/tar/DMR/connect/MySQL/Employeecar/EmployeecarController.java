package com.tar.DMR.connect.MySQL.Employeecar;

import com.tar.DMR.connect.MySQL.carregis.Carregis;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "Employeecar")
public class EmployeecarController {



    private final EmployeecarService employeecarService ;

    public EmployeecarController(EmployeecarService employeecarService) {
        this.employeecarService = employeecarService;
    }

    @GetMapping(value = "/findById/{peopleId}")
    public Optional<Employeecar> findById(@PathVariable Integer peopleId){
        return employeecarService.findById(peopleId);
    }

    @DeleteMapping(value = "/deleteById/{peopleId}")
    public void deleteById(@PathVariable Integer peopleId){
        employeecarService.deleteById(peopleId);
    }

    @GetMapping(value = "/findAll")
    public List<Employeecar> findAll(){ return employeecarService.findAll(); }



    @PutMapping(value = "/save")
    public Employeecar save(@RequestBody Employeecar employeecar){
        return employeecarService.save(employeecar);
    }




    @PutMapping(value = "/saveAll")
    public List<Employeecar> saveAll( @RequestBody List<Employeecar> employeecarList){return employeecarService.saveAll(employeecarList);}

//    @GetMapping(value = "/findByDriverNameAndLastName/{driveName}/{driverLastname}")
//    public Employeecar findByDriverNameAndLastName(@PathVariable String driveName,@PathVariable String driverLastname){
//        return employeecarService.findByDriverNameAndLastName(driveName,driverLastname);
//    }
}
