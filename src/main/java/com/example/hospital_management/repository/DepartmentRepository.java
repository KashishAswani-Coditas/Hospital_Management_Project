package com.example.hospital_management.repository;

import com.example.hospital_management.entity.Department;
import com.example.hospital_management.enums.DeptName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDeptName(DeptName deptName);
}
