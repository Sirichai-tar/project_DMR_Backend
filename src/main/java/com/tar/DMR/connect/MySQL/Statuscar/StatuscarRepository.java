package com.tar.DMR.connect.MySQL.Statuscar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatuscarRepository extends JpaRepository<Statuscar, Integer> {

    @Query(value = "select * from statuscar WHERE people_id = ?1 AND car_id = ?2",nativeQuery = true)
    Optional<Statuscar> findAllById(Integer peopleId, Integer carId);
}


