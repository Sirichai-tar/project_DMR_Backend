package com.tar.DMR.connect.MySQL.carregis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarregisRepository extends JpaRepository<Carregis , Integer> {

    @Query(value = "SELECT * FROM `carregis`WHERE car_regis = ?1" ,nativeQuery = true)
    Carregis findByIdRegistercar(String carRegis);
}
