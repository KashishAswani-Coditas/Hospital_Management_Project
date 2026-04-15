package com.example.hospital_management.controller;

import com.example.hospital_management.dto.request.AppointmentRequestDTO;
import com.example.hospital_management.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/admin/book_appointment")
    public String bookAppointment(@Valid @RequestBody AppointmentRequestDTO appointment){
        return appointmentService.bookAppointment(appointment);
    }
}
