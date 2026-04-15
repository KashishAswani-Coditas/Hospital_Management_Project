package com.example.hospital_management.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter @Setter
public class PatientResponseDTO {
    private Long id;
    private String phone_num;
    private UserResponseDTO userResponseDTO;
}
