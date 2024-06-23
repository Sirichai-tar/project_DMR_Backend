package com.tar.DMR.connect.MySQL.Statuscar;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "Statuscar")
@Transactional(rollbackFor = Exception.class)
public class StatuscarController {



    private final StatuscarService statuscarService ;

    public StatuscarController(StatuscarService statuscarService) {
        this.statuscarService = statuscarService;
    }


    @GetMapping (value = "/findAllById/{peopleId}/{carId}")
    public Optional<Statuscar> findAllById(@PathVariable Integer peopleId , @PathVariable Integer carId ){
       return statuscarService.findAllById(peopleId,carId);
    }

    @PutMapping(value = "/save")
    public Statuscar save(@RequestBody Statuscar statuscar){
      return statuscarService.save(statuscar);
    }

    @GetMapping (value = "/findAll")
    public List<Statuscar> fiandAll(){
        return statuscarService.findAll();
    }

    @DeleteMapping (value = "/deleteById/{statusId}")
    public void deleteById(@PathVariable Integer statusId){
         statuscarService.deleteById(statusId);
    }

}
