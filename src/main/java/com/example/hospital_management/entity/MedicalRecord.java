package com.example.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecord {
    @Id
    private Long id;
//
//    @NotBlank(message = "Field can't be blank or null")
    private String bloodGroup;

//    @NotBlank(message = "Field can't be blank or null")
    private String allergies;

//    @NotBlank(message = "Field can't be blank or null")
    private String pastDiseases;

//    @NotBlank(message = "Field can't be blank or null")
    private String currentMedication;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
