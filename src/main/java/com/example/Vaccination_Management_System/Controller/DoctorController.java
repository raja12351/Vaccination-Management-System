package com.example.Vaccination_Management_System.Controller;

import com.example.Vaccination_Management_System.Dtos.AssociateDocDto;
import com.example.Vaccination_Management_System.Models.Doctor;
import com.example.Vaccination_Management_System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add-doctor")
    public String addDoctor(@RequestBody Doctor doctor){
        try{
            return doctorService.addDoctor(doctor);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/associate-Doctor")
    public ResponseEntity<String> associateDoctor(@RequestBody AssociateDocDto associateDocDto){
        try{
            String result = doctorService.associateDoc(associateDocDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
