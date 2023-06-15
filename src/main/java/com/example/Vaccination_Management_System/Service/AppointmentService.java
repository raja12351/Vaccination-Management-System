package com.example.Vaccination_Management_System.Service;

import com.example.Vaccination_Management_System.Dtos.AppointmentDto;
import com.example.Vaccination_Management_System.Exceptions.DoctorNotFound;
import com.example.Vaccination_Management_System.Exceptions.UserNotFound;
import com.example.Vaccination_Management_System.Models.Appointment;
import com.example.Vaccination_Management_System.Models.Doctor;
import com.example.Vaccination_Management_System.Models.User;
import com.example.Vaccination_Management_System.Repository.AppointmentRepository;
import com.example.Vaccination_Management_System.Repository.DoctorRepository;
import com.example.Vaccination_Management_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;
    public String bookAppointment(AppointmentDto appointmentDto) throws UserNotFound, DoctorNotFound {
        int userId = appointmentDto.getUserId();
        int docId = appointmentDto.getDocId();

        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Doctor> doctorOptional = doctorRepository.findById(docId);

        if(userOptional.isEmpty()){
            throw new UserNotFound("User is not present in th database with id " + userId);
        }
        if(doctorOptional.isEmpty()){
            throw new DoctorNotFound("Doctor is not present in the database with id " + docId);
        }

        User user = userOptional.get();
        Doctor doctor = doctorOptional.get();

        Appointment appointment = new Appointment();

        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());

        appointment.setDoctor(doctor);
        appointment.setUser(user);

        appointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);

        return "Appointment booked successfully with doctor " + doctor.getName();
    }
}
