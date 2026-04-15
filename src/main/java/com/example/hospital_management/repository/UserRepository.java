package com.example.hospital_management.repository;

import com.example.hospital_management.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
