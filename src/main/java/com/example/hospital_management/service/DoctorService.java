package com.example.hospital_management.service;

import com.example.hospital_management.dto.request.DoctorRequestDTO;
import com.example.hospital_management.dto.response.DoctorResponseDTO;
import com.example.hospital_management.entity.Appointment;
import com.example.hospital_management.entity.Department;
import com.example.hospital_management.entity.Doctor;
import com.example.hospital_management.entity.Users;
import com.example.hospital_management.enums.Role;
import com.example.hospital_management.exceptions.DepartmentNotFoundException;
import com.example.hospital_management.repository.DepartmentRepository;
import com.example.hospital_management.repository.DoctorRepository;
import com.example.hospital_management.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepo;
    private final DepartmentRepository deptRepo;

    public DoctorResponseDTO addDoctor( DoctorRequestDTO doctor) {

        Department dept = deptRepo.findByDeptName(doctor.getDepartmentName())
                .orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));

        Users users = Users.builder()
                .username(doctor.getUsername())
                .email(doctor.getEmail())
                .password(doctor.getPassword())
                .role(Role.ROLE_DOCTOR)
                .build();
        Doctor originalDoctor = Doctor.builder()
                .experience(doctor.getExperience())
                .department(dept)
                .users(users).build();

        users.setDoctor(originalDoctor);
        doctorRepo.save(originalDoctor);
        return mapToResponse(originalDoctor);
    }

    private DoctorResponseDTO mapToResponse(Doctor doctor){
        return DoctorResponseDTO.builder()
                .name(doctor.getUsers().getUsername())
                .department(doctor.getDepartment().getDeptName().name())
                .experience(doctor.getExperience())
                .build();
    }

    public DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO dto){

        Doctor doctor = doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        if(dto.getUsername() != null){
            doctor.getUsers().setUsername(dto.getUsername());
        }

        if(dto.getEmail() != null){
            doctor.getUsers().setEmail(dto.getEmail());
        }

        if(dto.getPassword() != null){
            doctor.getUsers().setPassword(dto.getPassword());
        }

        if(dto.getExperience() != null){
            doctor.setExperience(dto.getExperience());
        }

        doctorRepo.save(doctor);

        return mapToResponse(doctor);
    }
}
