package com.tar.DMR.connect.MySQL.Registercar;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RegistercarRepository extends JpaRepository<Registercar, Integer> {
    @Query(value = "select r.* from register r inner join carregis c on c.car_id = r.car_id", nativeQuery = true)
    List<Registercar> findAllStatusCar();

//    Optional<Registercar> findById(Integer registerId, Integer carId, Integer peopleId);


//    @Query(value = "SELECT employeecar.phone_number, carregis.car_regis,carregis.car_type,carregis.car_nature, register.driver_name " +
//            "FROM register " +
//            "INNER JOIN carregis ON carregis.car_regis = register.car_regis " +
//            "INNER JOIN employeecar ON employeecar.driver_name = SUBSTRING_INDEX(register.driver_name, ' ', 1)",
//            nativeQuery = true)
//    List<ViewRegistercar> findAllView();
}
