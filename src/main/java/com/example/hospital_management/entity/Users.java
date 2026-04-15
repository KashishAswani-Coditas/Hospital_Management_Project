package com.example.hospital_management.entity;


import com.example.hospital_management.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "users" )
    private Patient patient;

    @OneToOne(mappedBy = "users" )
    private Doctor doctor;

    @OneToOne(mappedBy = "users" )
    private Admin admin;
}
