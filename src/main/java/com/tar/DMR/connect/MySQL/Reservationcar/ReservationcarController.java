package com.tar.DMR.connect.MySQL.Reservationcar;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "Reservationcar")
@Transactional(rollbackFor = Exception.class)
public class ReservationcarController {


    private final ReservationcarService reservationcarService ;

    public ReservationcarController(ReservationcarService reservationcarService) {
        this.reservationcarService = reservationcarService;
    }

    @PutMapping(value = "/save")
    public Reservationcar save(@RequestBody Reservationcar reservationcar){
       return reservationcarService.save(reservationcar) ;

    }
    @DeleteMapping(value = "/deleteById/{reservationId}")
    public void deleteById(@PathVariable Integer reservationId){
        reservationcarService.deleteById(reservationId);
    }


}

