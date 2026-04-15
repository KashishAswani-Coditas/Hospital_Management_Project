package com.example.hospital_management.dto.response;

import com.example.hospital_management.enums.Role;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter @Setter
public class UserResponseDTO {
    private String username;
    private Role role;
}
