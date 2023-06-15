package com.example.Vaccination_Management_System.Service;

import com.example.Vaccination_Management_System.Dtos.AssociateDocDto;
import com.example.Vaccination_Management_System.Exceptions.CenterNotFoundException;
import com.example.Vaccination_Management_System.Exceptions.DocotorNotRegisteredException;
import com.example.Vaccination_Management_System.Exceptions.DoctorAlreadyPresentException;
import com.example.Vaccination_Management_System.Exceptions.EmailIdEmptyException;
import com.example.Vaccination_Management_System.Models.Doctor;
import com.example.Vaccination_Management_System.Models.VaccinationCenter;
import com.example.Vaccination_Management_System.Repository.DoctorRepository;
import com.example.Vaccination_Management_System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public String addDoctor(Doctor doctor) throws EmailIdEmptyException, DoctorAlreadyPresentException {
        if(doctor.getEmailId()==null){
            throw new EmailIdEmptyException("EmailId is mandatory!");
        }
        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null){
            throw new DoctorAlreadyPresentException("Doctor is already registered.");
        }

        doctorRepository.save(doctor);

        return "Doctor is successfully registered to database.";
    }

    public String associateDoc(AssociateDocDto associateDocDto) throws DocotorNotRegisteredException, CenterNotFoundException {
        int docId = associateDocDto.getDocId();

        Optional<Doctor> doctor = doctorRepository.findById(docId);

        if(!doctor.isPresent()){
            throw new DocotorNotRegisteredException("No Doctor with the given id "+ docId + " is present in database.");
        }

        int centerId = associateDocDto.getCenterId();

        Optional<VaccinationCenter> center = vaccinationCenterRepository.findById(centerId);

        if(!center.isPresent()){
            throw new CenterNotFoundException("There is no center with id "+centerId+" int the database.");
        }

        Doctor doctor1 = doctor.get();
        VaccinationCenter vaccinationCenter = center.get();

        doctor1.setVaccinationCenter(vaccinationCenter);
        vaccinationCenter.getDoctorList().add(doctor1);

        vaccinationCenterRepository.save(vaccinationCenter);

        return "Doctor has been registered successfully at the center " + vaccinationCenter.getName();
    }
}

