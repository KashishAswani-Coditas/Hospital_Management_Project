package com.example.hospital_management.service;

import com.example.hospital_management.dto.request.AdminRequestDTO;
import com.example.hospital_management.dto.response.AdminResponseDTO;
import com.example.hospital_management.dto.response.UserResponseDTO;
import com.example.hospital_management.entity.Admin;
import com.example.hospital_management.entity.Users;
import com.example.hospital_management.enums.Role;
import com.example.hospital_management.repository.AdminRepository;
import com.example.hospital_management.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepo;
    private final AdminRepository adminRepo;

    public AdminResponseDTO registerAdmin(@Valid AdminRequestDTO admin) {
        Users users = Users.builder()
                .username(admin.getUsername())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .role(Role.ROLE_ADMIN)
                .build();
        Admin originalAdmin = Admin.builder()
                .designation(admin.getDesignation())
                .users(users)
                .build();

        adminRepo.save(originalAdmin);
        userRepo.save(users);

        return response(originalAdmin);

    }

    private AdminResponseDTO response(Admin admin){
        return AdminResponseDTO.builder()
                .user(userResponse(admin.getUsers()))
                .designation(admin.getDesignation())
                .build();
    }

    private UserResponseDTO userResponse(Users users){
        return UserResponseDTO.builder()
                .username(users.getUsername())
                .role(users.getRole())
                .build();

    }
}
