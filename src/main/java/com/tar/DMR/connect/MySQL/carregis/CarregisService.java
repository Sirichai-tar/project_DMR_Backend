package com.tar.DMR.connect.MySQL.carregis;


import com.tar.DMR.connect.MySQL.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class CarregisService {

    @Autowired
    private CarregisRepository carregisRepository;

    public Carregis save(Carregis carregis) {
        // bast 64 to byte
        byte[] imagebytes = ImageUtils.stringToByte(carregis.getCarshowImg());
        carregis.setCarImg(imagebytes);
//        System.out.println(imagebytes);
        return carregisRepository.save(carregis);
    }
    public List<Carregis> findAll() {

        List<Carregis> carregis  = carregisRepository.findAll();
        // byte to bast 64 or Sting
        carregis.forEach(data->{
         String bast64  = ImageUtils.byteToString(data.getCarImg());
//         System.out.println(bast64);
         data.setCarshowImg(bast64);
        });
        return carregis;
    }

    public void deleteById(Integer carId) {
        carregisRepository.deleteById(carId);
    }

    public List<Carregis> saveAll(List<Carregis> carregisList) {
        return carregisRepository.saveAll(carregisList);
    }

    public Carregis findByIdRegistercar(String carRegis) {
        return carregisRepository.findByIdRegistercar(carRegis);
    }

    public Optional<Carregis> findById(Integer carId) {
        return carregisRepository.findById(carId);
    }


//   public void uploadImage(Integer carId, MultipartFile file) throws IOException {
//        Carregis carregis = carregisRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
//       carregis.setCarImg(file.getBytes());
//        carregisRepository.save(carregis);
//   }
}