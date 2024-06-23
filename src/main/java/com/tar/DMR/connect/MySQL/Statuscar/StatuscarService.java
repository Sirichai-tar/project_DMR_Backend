package com.tar.DMR.connect.MySQL.Statuscar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatuscarService {


    @Autowired
    private StatuscarRepository statuscarRepository;


    public Statuscar save(Statuscar statuscar) {
        return statuscarRepository.save(statuscar);
    }

    public List<Statuscar> findAll() {
        return statuscarRepository.findAll();
    }

    public void deleteById(Integer statusId) {
        statuscarRepository.deleteById(statusId);
    }

    public Optional<Statuscar> findAllById(Integer peopleId, Integer carId) {  return statuscarRepository.findAllById(peopleId,carId);
    }
}
