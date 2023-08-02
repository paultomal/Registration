package com.paul.registrationform.repository;

import com.paul.registrationform.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
    Registration findByFirstName(String firstName);
    Registration findByLastName(String lastName);
}
