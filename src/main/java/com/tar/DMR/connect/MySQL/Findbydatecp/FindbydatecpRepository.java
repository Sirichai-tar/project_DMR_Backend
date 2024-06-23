package com.tar.DMR.connect.MySQL.Findbydatecp;

import com.tar.DMR.connect.MySQL.Registercar.Registercar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FindbydatecpRepository extends JpaRepository<Registercar , Integer> {
    @Query(value = "select carregis.* , employeecar.*  register.* from register inner join carregis on carregis.car_id = register.car_id inner join employeecar on register.people_id = employeecar.people_id", nativeQuery = true)
    List<Registercar> findBydate();
}
