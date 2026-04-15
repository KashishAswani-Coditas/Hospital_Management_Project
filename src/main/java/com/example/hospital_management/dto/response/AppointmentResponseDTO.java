package com.example.hospital_management.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDTO {
    private Long id;
    private LocalDate date;
    private LocalTime scheduledAt;

    private String patientName;
    private String doctorName;
}
