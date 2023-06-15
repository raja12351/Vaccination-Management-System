package com.example.Vaccination_Management_System.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociateDocDto {
    private Integer docId;
    private Integer centerId;
}
