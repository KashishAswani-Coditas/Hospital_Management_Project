package com.example.hospital_management.dto.request;

import com.example.hospital_management.enums.DeptName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequestDTO {

    @NotNull(message = "Dept name can't be null")
    private DeptName deptName;

    @NotBlank(message = "Dept location is compulsory")
    private String deptLocation;
}
