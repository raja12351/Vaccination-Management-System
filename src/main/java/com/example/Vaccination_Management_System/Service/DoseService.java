package com.example.Vaccination_Management_System.Service;

import com.example.Vaccination_Management_System.Models.Dose;
import com.example.Vaccination_Management_System.Models.User;
import com.example.Vaccination_Management_System.Repository.DoseRepository;
import com.example.Vaccination_Management_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;

    public String giveDose(String doseId, Integer userId) {
        User user = userRepository.findById(userId).get();

        Dose dose = new Dose();

        dose.setDoseId(doseId);
        dose.setUser(user);
        user.setDose(dose);

        userRepository.save(user);

        return "Dose given to user successfully.";
    }
}
