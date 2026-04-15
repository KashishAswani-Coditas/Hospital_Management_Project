package com.example.hospital_management.controller;

import com.example.hospital_management.dto.request.MedicalRecordRequestDTO;
import com.example.hospital_management.dto.response.AppointmentResponseDTO;
import com.example.hospital_management.entity.MedicalRecord;
import com.example.hospital_management.service.AppointmentService;
import com.example.hospital_management.service.DoctorService;
import com.example.hospital_management.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final MedicalRecordService medicalRecordService;
    private final AppointmentService appointmentService;

    @GetMapping("/appointments/{id}")
    public List<AppointmentResponseDTO> getAppointments(@PathVariable Long id){
        return appointmentService.getAppointments(id);
    }

    @PostMapping("/add_medical_record")
    public String addMedicalRecord(@Valid @RequestBody MedicalRecordRequestDTO medicalRecord){
        return medicalRecordService.addMedicalRecord(medicalRecord);
    }
}
