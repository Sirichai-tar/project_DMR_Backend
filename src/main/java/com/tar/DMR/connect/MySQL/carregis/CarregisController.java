package com.tar.DMR.connect.MySQL.carregis;


import com.tar.DMR.connect.MySQL.Registercar.Registercar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

// CrossOrigin ("http:// localhost:4200") เป็น post ของ angular //
@RestController
@RequestMapping(value = "Carregis")
public class CarregisController {

    private final CarregisService carregisService;

    public CarregisController(CarregisService carregisService) {
        this.carregisService = carregisService;
    }

    @GetMapping(value = "/findById/{carId}")
    public Optional<Carregis> findById(@PathVariable Integer carId){
        return carregisService.findById(carId);
    }

    @GetMapping(value = "/findAll")
    public List<Carregis> findAll() {
        return carregisService.findAll();
    }


    @PutMapping(value = "/save")
    public Carregis save(@RequestBody Carregis carregis) {
        return carregisService.save(carregis);
    }


    @DeleteMapping(value = "/deleteById/{carId}")
    public void deleteById(@PathVariable Integer carId) {
        carregisService.deleteById(carId);
    }

    @PutMapping(value = "/saveAll")
    public List<Carregis> saveAll(@RequestBody List<Carregis> carregisList) {
        return carregisService.saveAll(carregisList);
    }

    @GetMapping (value = "/findByIdRegistercar/{carRegis}")
    public  Carregis findByIdRegistercar(@PathVariable String carRegis){
        return carregisService.findByIdRegistercar(carRegis);
    }

//    @PutMapping(value = "/uploadImage/{carId}")
//   public ResponseEntity<String> uploadImage(@PathVariable Integer carId, @RequestPart("file") MultipartFile file) throws IOException {
//       carregisService.uploadImage(carId,file);
//        return ResponseEntity.ok("Image uplosded susecc");
//   }

}
