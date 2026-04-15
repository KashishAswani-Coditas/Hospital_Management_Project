package com.example.hospital_management.controller;

import com.example.hospital_management.dto.request.PatientRequestDTO;
import com.example.hospital_management.dto.response.PatientResponseDTO;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.PatientRepository;
import com.example.hospital_management.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/register")
    public PatientResponseDTO addPatient(@Valid @RequestBody PatientRequestDTO patient){
        return patientService.register(patient);
    }


}
