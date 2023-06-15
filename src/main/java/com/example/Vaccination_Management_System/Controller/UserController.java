package com.example.Vaccination_Management_System.Controller;

import com.example.Vaccination_Management_System.Dtos.UpdateEmailDto;
import com.example.Vaccination_Management_System.Models.User;
import com.example.Vaccination_Management_System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/getVaccinationDate")
    public Date getVaccinationDate(@RequestParam("userId")Integer userId){
        return userService.getVaccDate(userId);
    }

    @PutMapping("/update-email")
    public String updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
        return userService.updateEmail(updateEmailDto);
    }

    @GetMapping("/user-by-email/{emailId}")
    public User getUserByEmail(@PathVariable("emailId")String emailId){
        return userService.getUserByEmail(emailId);
    }
}
