package com.example.Vaccination_Management_System.Controller;

import com.example.Vaccination_Management_System.Dtos.AppointmentDto;
import com.example.Vaccination_Management_System.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/bookingAppointment")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDto appointmentDto){
        try{
            return new ResponseEntity<>(appointmentService.bookAppointment(appointmentDto), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
