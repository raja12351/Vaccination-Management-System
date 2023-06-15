package com.example.Vaccination_Management_System.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "doses")
@Data
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String doseId;

    private Date vaccinationDate;

    @OneToOne
    @JoinColumn
    private User user;
}
