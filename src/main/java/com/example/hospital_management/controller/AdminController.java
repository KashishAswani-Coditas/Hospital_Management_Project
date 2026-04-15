package com.example.hospital_management.controller;

import com.example.hospital_management.dto.request.AdminRequestDTO;
import com.example.hospital_management.dto.request.AppointmentRequestDTO;
import com.example.hospital_management.dto.request.DoctorRequestDTO;
import com.example.hospital_management.dto.request.PatientRequestDTO;
import com.example.hospital_management.dto.response.AdminResponseDTO;
import com.example.hospital_management.dto.response.AppointmentResponseDTO;
import com.example.hospital_management.dto.response.DoctorResponseDTO;
import com.example.hospital_management.dto.response.PatientResponseDTO;
import com.example.hospital_management.service.AdminService;
import com.example.hospital_management.service.AppointmentService;
import com.example.hospital_management.service.DoctorService;
import com.example.hospital_management.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;


    @GetMapping("/hello")
    public String sayHello(){
        return "Hellooo!!!";
    }

    @PostMapping("/signup")
    public AdminResponseDTO registerAdmin(@Valid @RequestBody AdminRequestDTO admin){
        return adminService.registerAdmin(admin);
    }

    @PostMapping("/register_patient")
    public PatientResponseDTO addPatient(@Valid @RequestBody PatientRequestDTO patient){
        return patientService.register(patient);
    }

    @PostMapping("/register_doctor")
    public DoctorResponseDTO addDoctor(@Valid @RequestBody DoctorRequestDTO doctor){
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/appointments")
    public List<AppointmentResponseDTO> getAppointmentsByDate(@RequestParam String date){
        return appointmentService.getAppointmentsByDate(LocalDate.parse(date));
    }

    @PatchMapping("/appointment/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status){
        return appointmentService.updateStatus(id, status);
    }

    @PatchMapping("/doctor/{id}")
    public DoctorResponseDTO updateDoctor(@PathVariable Long id,
                                          @RequestBody DoctorRequestDTO dto){
        return doctorService.updateDoctor(id, dto);
    }

    @PatchMapping("/patient/{id}")
    public PatientResponseDTO updatePatient(@PathVariable Long id,
                                            @RequestBody PatientRequestDTO dto){
        return patientService.updatePatient(id, dto);
    }
}
