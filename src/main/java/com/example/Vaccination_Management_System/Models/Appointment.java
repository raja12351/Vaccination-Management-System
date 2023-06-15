package com.example.Vaccination_Management_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date appointmentDate; //YYYY-MM-DD

    private LocalTime appointmentTime; //HH-MM-SS

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Doctor doctor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private User user;
}
