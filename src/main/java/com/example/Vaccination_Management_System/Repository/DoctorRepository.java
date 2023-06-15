package com.example.Vaccination_Management_System.Repository;

import com.example.Vaccination_Management_System.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByEmailId(String emailId);
}
