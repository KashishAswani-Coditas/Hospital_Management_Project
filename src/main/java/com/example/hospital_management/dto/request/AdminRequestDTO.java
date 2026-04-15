package com.example.hospital_management.dto.request;

import com.example.hospital_management.entity.Users;
import com.example.hospital_management.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class AdminRequestDTO {

    @NotBlank(message = "Username can't be blank")
    private String username;

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 8, max = 12, message = "Password length must be between 8 to 12 chars")
    private String password;

    @NotBlank(message = "Designation can't be blank")
    private String designation;

}
