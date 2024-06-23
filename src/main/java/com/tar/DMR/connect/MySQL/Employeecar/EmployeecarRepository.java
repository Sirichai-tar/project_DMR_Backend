package com.tar.DMR.connect.MySQL.Employeecar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeecarRepository extends JpaRepository<Employeecar, Integer> {

    @Query(value = "SELECT * FROM employeecar WHERE driver_name = ?1 AND driver_lastname = ?2 ",nativeQuery = true)
    Employeecar findByDriverNameAndLastName(String driveName, String driverLastname);
}
