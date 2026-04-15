package com.example.hospital_management.dto.response;

import lombok.*;
import org.springframework.stereotype.Service;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AdminResponseDTO {
    private UserResponseDTO user;
    private String designation;
}
