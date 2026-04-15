package com.example.hospital_management.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DoctorResponseDTO {
    private String  name;
    private String department;
    private int experience;
}
