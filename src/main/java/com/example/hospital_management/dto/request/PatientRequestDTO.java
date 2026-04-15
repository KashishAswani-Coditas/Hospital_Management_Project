package com.example.hospital_management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
public class PatientRequestDTO {

    @NotBlank(message = "Name can't be blank or null")
    private String name;

    @Length(min = 10, max = 10, message = "Invalid phone number")
    private String phone_num;

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 8, max = 12, message = "Password length must be between 8 to 12 chars")
    private String password;

    @NotBlank(message = "Address can't be blank or null")
    private String address;
}
