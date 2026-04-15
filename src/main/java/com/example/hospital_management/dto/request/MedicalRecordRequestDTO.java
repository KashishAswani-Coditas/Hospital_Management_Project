package com.example.hospital_management.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalRecordRequestDTO {

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    private String bloodGroup;
    private String allergies;
    private String pastDiseases;
    private String currentMedication;
}
