package com.example.hospital_management.controller;

import com.example.hospital_management.dto.request.DepartmentRequestDTO;
import com.example.hospital_management.entity.Department;
import com.example.hospital_management.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/add")
    public String addDepartment(@Valid @RequestBody DepartmentRequestDTO dept){
        return departmentService.addDept(dept);
    }
}
