package com.example.hospital_management.entity;

import com.example.hospital_management.enums.DeptName;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeptName deptName;

    private String deptLocation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", orphanRemoval = true)
    private List<Doctor> doctorList;

}
