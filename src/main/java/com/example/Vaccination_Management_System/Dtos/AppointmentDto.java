package com.example.Vaccination_Management_System.Dtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentDto {
    private int docId;

    private int userId;

    private LocalTime appointmentTime;

    private Date appointmentDate;
}
