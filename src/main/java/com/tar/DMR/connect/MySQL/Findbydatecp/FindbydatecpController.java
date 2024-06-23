package com.tar.DMR.connect.MySQL.Findbydatecp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "Findbydatecp")
public class FindbydatecpController {

    private  final FindbydatecpService findbydatecpService;

    public FindbydatecpController(FindbydatecpService findbydatecpService) {
        this.findbydatecpService = findbydatecpService;
    }

    @GetMapping(value = "/findBydate")
    public List<Findbydatecp> findBydate(){
        return findbydatecpService.findBydate();
    }

}
