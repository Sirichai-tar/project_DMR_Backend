package com.tar.DMR.connect.MySQL.Registercar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping(value = "Register")
public class RegistercarController {

    private final  RegistercarService registercarService;


    public RegistercarController(RegistercarService registercarService) {
        this.registercarService = registercarService;
    }
//    @GetMapping(value = "/findById/{registerId}/{carId}/{peopleId}")
//    public Optional<Registercar> findById(@PathVariable Integer registerId ,@PathVariable Integer carId ,@PathVariable Integer peopleId ){return registercarService.findById(registerId ,carId , peopleId);}

    @GetMapping(value = "/findAll")
    public List<Registercar> findAll(){return registercarService.findAll();}

    @GetMapping(value = "/findAllStatusCar")
    public List<TableRegistercar> findAllStatusCar(){return registercarService.findAllStatusCar();}

    @PutMapping(value = "/save")
    public Registercar save(@RequestBody Registercar registercar){return registercarService.save(registercar);}

    @DeleteMapping(value = "/deleteById/{registerId}")
    public void deleteById(@PathVariable Integer registerId){registercarService.deleteById(registerId);}

    @PutMapping(value = "/saveAll")
    public List<Registercar> saveAll(@RequestBody List<Registercar> registercarList){
        return registercarService.saveAll(registercarList);
    }


//   @GetMapping(value = "/findAllView")
//   public List<ViewRegistercar> findAllView(){return  registercarService.findAllView();}
}

