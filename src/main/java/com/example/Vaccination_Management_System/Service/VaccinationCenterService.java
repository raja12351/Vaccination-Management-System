package com.example.Vaccination_Management_System.Service;

import com.example.Vaccination_Management_System.Exceptions.VaccinationAddressNotFound;
import com.example.Vaccination_Management_System.Models.VaccinationCenter;
import com.example.Vaccination_Management_System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public String addcenter(VaccinationCenter vaccinationCenter) throws VaccinationAddressNotFound {
        if(vaccinationCenter.getAddress()==null){
            throw new VaccinationAddressNotFound("Center Location is Mandatory.");
        }
        vaccinationCenterRepository.save(vaccinationCenter);
        return "Center is added successfully with address " + vaccinationCenter.getAddress();
    }
}
