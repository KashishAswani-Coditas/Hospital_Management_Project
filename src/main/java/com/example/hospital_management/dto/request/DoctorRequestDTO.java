package com.example.hospital_management.dto.request;

import com.example.hospital_management.enums.DeptName;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
public class DoctorRequestDTO {

    @NotBlank(message = "Username can't be blank or null")
    private String username;

    @NotNull(message = "Department field can't be null")
    private DeptName departmentName;

    @Email(message = "Invalid email")
    private String email;

    @Size(min = 8, max = 12, message = "Password length must be between 8 to 12 chars")
    private String password;

    @NotNull(message = "Experience is required")
    @Min(value = 0, message = "Experience cannot be negative")
    @Max(value = 50, message = "Experience seems unrealistic")
    private Integer experience;

}
