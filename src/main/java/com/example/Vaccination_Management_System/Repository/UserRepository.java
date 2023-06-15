package com.example.Vaccination_Management_System.Repository;

import com.example.Vaccination_Management_System.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailId(String emailId);
}
