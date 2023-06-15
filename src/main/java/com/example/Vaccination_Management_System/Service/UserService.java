package com.example.Vaccination_Management_System.Service;

import com.example.Vaccination_Management_System.Dtos.UpdateEmailDto;
import com.example.Vaccination_Management_System.Models.Dose;
import com.example.Vaccination_Management_System.Models.User;
import com.example.Vaccination_Management_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    public Date getVaccDate(Integer userId) {

        User user = userRepository.findById(userId).get();
        Dose dose = user.getDose();
        return dose.getVaccinationDate();
    }

    public String updateEmail(UpdateEmailDto updateEmailDto) {
        int userId = updateEmailDto.getUserId();
        User user = userRepository.findById(userId).get();

        String emailId = updateEmailDto.getNewEmailId();
        user.setEmailId(emailId);
        userRepository.save(user);

        return "Old emailId is changed by " + emailId;
    }

    public User getUserByEmail(String emailId) {
        return userRepository.findByEmailId(emailId);
    }
}
