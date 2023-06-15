package com.example.Vaccination_Management_System.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmailDto {
    private int userId;
    private String newEmailId;
}
