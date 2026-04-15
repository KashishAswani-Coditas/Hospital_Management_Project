package com.example.hospital_management.service;

import com.example.hospital_management.dto.request.MedicalRecordRequestDTO;
import com.example.hospital_management.entity.MedicalRecord;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.exceptions.PatientNotFoundException;
import com.example.hospital_management.repository.MedicalRecordRepository;
import com.example.hospital_management.repository.PatientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final PatientRepository patientRepo;
    private final MedicalRecordRepository medicalRecordRepo;

    public String addMedicalRecord(@Valid MedicalRecordRequestDTO dto) {

        Patient p = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

        MedicalRecord record = medicalRecordRepo.findById(p.getPatient_id())
                .orElse(new MedicalRecord());

        if (dto.getBloodGroup() != null)
            record.setBloodGroup(dto.getBloodGroup());

        if (dto.getAllergies() != null)
            record.setAllergies(dto.getAllergies());

        if (dto.getPastDiseases() != null)
            record.setPastDiseases(dto.getPastDiseases());

        if (dto.getCurrentMedication() != null)
            record.setCurrentMedication(dto.getCurrentMedication());

        record.setPatient(p);

        medicalRecordRepo.save(record);

        return "Record saved successfully";
    }
}
