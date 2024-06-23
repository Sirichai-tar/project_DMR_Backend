package com.tar.DMR.connect.MySQL.Reservationcar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationcarService {


    @Autowired
    private ReservationcarRepository reservationcarRepository;

    public Reservationcar save(Reservationcar reservationcar) {
        return reservationcarRepository.save(reservationcar);
    }

    public void deleteById(Integer reservationId) {
        reservationcarRepository.deleteById(reservationId);
    }
}
