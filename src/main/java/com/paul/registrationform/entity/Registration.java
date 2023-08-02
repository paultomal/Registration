package com.paul.registrationform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registration_tbl")
public class Registration {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    //@Pattern(regexp = Constants.PATTERN, flags = Pattern.Flag.CASE_INSENSITIVE)

    private String email;
    private LocalDate date;
    private String nationality;
    private String contact;
    private String address;
    private String result1;
    private String result2;
}
