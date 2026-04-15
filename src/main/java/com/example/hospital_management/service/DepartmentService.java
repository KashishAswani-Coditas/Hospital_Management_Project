package com.example.hospital_management.service;

import com.example.hospital_management.dto.request.DepartmentRequestDTO;
import com.example.hospital_management.entity.Department;
import com.example.hospital_management.repository.DepartmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepo;

    public String addDept(DepartmentRequestDTO dept) {
        Department originalDept = Department.builder()
                .deptName(dept.getDeptName())
                .deptLocation(dept.getDeptLocation())
                .build();

        departmentRepo.save(originalDept);

        return "Department added successfully!";
    }
}
