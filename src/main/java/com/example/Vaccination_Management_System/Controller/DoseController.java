package com.example.Vaccination_Management_System.Controller;

import com.example.Vaccination_Management_System.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/does")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/giveDose")
    public String giveDose(@RequestParam("doseId")String doseId , @RequestParam("userId")Integer userId){
        return doseService.giveDose(doseId,userId);
    }
}
