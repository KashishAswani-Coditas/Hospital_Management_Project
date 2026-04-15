package com.example.hospital_management.service;

import com.example.hospital_management.dto.request.PatientRequestDTO;
import com.example.hospital_management.dto.response.PatientResponseDTO;
import com.example.hospital_management.dto.response.UserResponseDTO;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.entity.Users;
import com.example.hospital_management.enums.Role;
import com.example.hospital_management.repository.PatientRepository;
import com.example.hospital_management.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public PatientResponseDTO register(PatientRequestDTO patient) {

        Users user = Users.builder()
                .username(patient.getName())
                .email(patient.getEmail())
                .password(passwordEncoder.encode(patient.getPassword()))
                .role(Role.ROLE_PATIENT)
                .build();

        Patient originalPatient = Patient.builder()
                .phone_num(patient.getPhone_num())
                .address(patient.getAddress())
                .users(user)
                .build();

        user.setPatient(originalPatient);

        patientRepo.save(originalPatient);
        userRepo.save(user);

        return mapToResponse(originalPatient);
    }

    private PatientResponseDTO mapToResponse(Patient patient){
        return PatientResponseDTO.builder()
                .id(patient.getPatient_id())
                .phone_num(patient.getPhone_num())
                .userResponseDTO(mapUser(patient.getUsers())).build();
    }

    private UserResponseDTO mapUser(Users user){
        return UserResponseDTO.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO dto){

        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        if(dto.getName() != null)
            patient.getUsers().setUsername(dto.getName());

        if(dto.getEmail() != null)
            patient.getUsers().setEmail(dto.getEmail());

        if(dto.getPassword() != null)
            patient.getUsers().setPassword(dto.getPassword());

        if(dto.getPhone_num() != null)
            patient.setPhone_num(dto.getPhone_num());

        if(dto.getAddress() != null)
            patient.setAddress(dto.getAddress());

        patientRepo.save(patient);

        return mapToResponse(patient);
    }
}
