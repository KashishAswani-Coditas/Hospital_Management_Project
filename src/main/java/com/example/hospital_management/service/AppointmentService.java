package com.example.hospital_management.service;

import com.example.hospital_management.dto.request.AppointmentRequestDTO;
import com.example.hospital_management.dto.response.AppointmentResponseDTO;
import com.example.hospital_management.entity.Appointment;
import com.example.hospital_management.entity.Doctor;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.enums.AppointmentStatus;
import com.example.hospital_management.exceptions.DoctorNotFoundException;
import com.example.hospital_management.exceptions.PatientNotFoundException;
import com.example.hospital_management.repository.AppointmentRepository;
import com.example.hospital_management.repository.DoctorRepository;
import com.example.hospital_management.repository.PatientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepo;
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;

    public String bookAppointment(@Valid AppointmentRequestDTO appointment) {

        Patient p = patientRepo.findById(appointment.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient does not exists"));
        Doctor d = doctorRepo.findById(appointment.getDoctorId())
                .orElseThrow(()-> new DoctorNotFoundException("Doctor does not exists"));

        Appointment originalAppointment = Appointment.builder()
                .date(appointment.getDate())
                .patient(p)
                .doctor(d)
                .scheduled_at(appointment.getScheduledAt())
                .status(AppointmentStatus.ACTIVE).build();

        appointmentRepo.save(originalAppointment);

        return "Appointment booking successful";
    }

    public List<AppointmentResponseDTO> getAppointments(Long id) {
        return appointmentRepo.findByDoctorId(id)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private AppointmentResponseDTO mapToDTO(Appointment appointment){
        return AppointmentResponseDTO.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .scheduledAt(appointment.getScheduled_at())
                .patientName(appointment.getPatient().getUsers().getUsername())
                .doctorName(appointment.getDoctor().getUsers().getUsername())
                .build();
    }

    public List<AppointmentResponseDTO> getAppointmentsByDate(LocalDate date) {
        return appointmentRepo.findByDate(date)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public String updateStatus(Long id, String status) {
        Appointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(AppointmentStatus.valueOf(status));

        appointmentRepo.save(appointment);

        return "Status updated";
    }
}
