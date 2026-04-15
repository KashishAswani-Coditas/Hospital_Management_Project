package com.example.hospital_management.entity;

import com.example.hospital_management.enums.AppointmentStatus;
import com.example.hospital_management.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_assigned")
    private Doctor doctor;

    private LocalTime scheduled_at;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;


}
