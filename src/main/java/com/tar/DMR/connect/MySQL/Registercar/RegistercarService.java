package com.tar.DMR.connect.MySQL.Registercar;

import com.tar.DMR.connect.MySQL.Employeecar.Employeecar;
import com.tar.DMR.connect.MySQL.Employeecar.EmployeecarRepository;
import com.tar.DMR.connect.MySQL.carregis.Carregis;
import com.tar.DMR.connect.MySQL.carregis.CarregisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RegistercarService {


    @Autowired
    private RegistercarRepository registercarRepository;
    @Autowired
    private CarregisRepository carregisRepository;
//    private EmployeecarRepository employeecarRepository;

    public List<Registercar> findAll() {
        return registercarRepository.findAll();
    }

    public Registercar save(Registercar registercar) {
        return registercarRepository.save(registercar);
    }

    public void deleteById(Integer registerId) {
        registercarRepository.deleteById(registerId);
    }

    public List<Registercar> saveAll(List<Registercar> registercarList) {
        return registercarRepository.saveAll(registercarList);
    }

    public List<TableRegistercar> findAllStatusCar() {

        List<TableRegistercar> tableRegistercarList = new ArrayList<>();
        List<Carregis> carregisList = carregisRepository.findAll();
        List<Registercar> registercarList = registercarRepository.findAllStatusCar();


        carregisList.forEach(c -> {
            TableRegistercar tableRegistercar = new TableRegistercar();
            tableRegistercar.setCarRegis(c.getCarRegis());
            tableRegistercarList.add(tableRegistercar);
        });

        if (registercarList != null) {

//            for (int i = 0; i < tableRegistercarList.size(); i++) {
//                for (int j = 0; j < registercarList.size(); j++) {
//                    if (registercarList.get(j).equals(tableRegistercarList.get(i))) {
//                        tableRegistercarList.get(i).setDriverName(registercarList.get(j).getDriverName());
//                        tableRegistercarList.get(i).setStartDate(registercarList.get(j).getStartDate());
//                        tableRegistercarList.get(i).setEndDate(registercarList.get(j).getEndDate());
//                    }
//                }
//            }

            tableRegistercarList.forEach(c -> {
                registercarList.forEach(r -> {
                    if (r.getCarRegis().equals(c.getCarRegis())) {
                        c.setPhonNumber(r.getPhonNumber());
                        c.setDriverName(r.getDriverName());
//                        c.setCarRegis(r.getCarRegis());
                        c.setStartDate(r.getStartDate());
                        c.setEndDate(r.getEndDate());

                    }
                });
            });

        }
        return tableRegistercarList;
    }




//    public Optional<Registercar> findById(Integer registerId, Integer carId, Integer peopleId) {
//        return  registercarRepository.findById(registerId,carId,peopleId);
//    }


//    public List<ViewRegistercar> findAllView() {
//       List<ViewRegistercar> viewRegistercarList = new ArrayList<>();
//       List<Carregis> carregisList = carregisRepository.findAll();
//       List<Employeecar> employeecarList  = employeecarRepository.findAll();
//       List<Registercar> registercarList = registercarRepository.findAll();
//        List<ViewRegistercar> registercarDataList = registercarRepository.findAllView();
//       List<String Registercar,String Employeecar> registercarList = registercarRepository.findAllView();
//       List<viewRegistercar> viewRegistercars = registercarRepository.findAllView();

//     carregisList.forEach(c -> {
//        ViewRegistercar viewRegistercar = new ViewRegistercar();
//           viewRegistercar.setCarRegis(c.getCarRegis());
//         viewRegistercarList.add(viewRegistercar);
//       });
//     employeecarList.forEach(e -> {
//         ViewRegistercar viewRegistercar = new ViewRegistercar();
//         viewRegistercar.setDriverName(e.getDriverName());
//         viewRegistercarList.add(viewRegistercar);
//     });
//
//     if (registercarList != null){
//         viewRegistercarList.forEach(viewRegistercar -> {
//             carregisList.forEach(carregis -> {
//                 if (carregis.getCarRegis().equals(viewRegistercar.getCarRegis())){
//                    viewRegistercar.setCarRegis(carregis.getCarRegis());
//                    viewRegistercar.setCarNature(carregis.getCarNature());
//                    viewRegistercar.setCarType(carregis.getCarType());
//                 }
//             });
//         });
//         viewRegistercarList.forEach(viewRegistercar -> {
//             employeecarList.forEach(employeecar -> {
//                 if (employeecar.getDriverName().equals(viewRegistercar.getDriverName()))
//                     viewRegistercar.setPhoneNumber(employeecar.getPhoneNumber());
//             });
//         });
//     }return viewRegistercarList;
//   }
}
