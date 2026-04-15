package com.example.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    private String phone_num;

    private String address;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patient", orphanRemoval = true)
    private MedicalRecord medicalRecord;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;

}
