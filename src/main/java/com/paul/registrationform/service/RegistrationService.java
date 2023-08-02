package com.paul.registrationform.service;

import com.paul.registrationform.entity.Registration;
import com.paul.registrationform.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepository repository;

    public RegistrationService(RegistrationRepository repository) {
        this.repository = repository;
    }
    public Registration saveRegistration(Registration registration){
        return repository.save(registration);
    }
    public List<Registration> saveAllRegistrations(List<Registration> registrations){
        return repository.saveAll(registrations);
    }
    public List<Registration> getAllRegistrations(){
        return repository.findAll();
    }
    public Registration getRegistrationByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }
    public Registration getRegistrationByLastName(String lastName){
        return repository.findByLastName(lastName);
    }
    public String deleteRegistration(int id){
        repository.deleteById(id);
        return "registration removed!! " +id;
    }
    public Registration updateRegistration(Registration registration){
        Registration existingRegistration = repository.findById(registration.getId()).orElse(null);
        existingRegistration.setFirstName(registration.getFirstName());
        existingRegistration.setLastName(registration.getLastName());
        existingRegistration.setEmail( registration.getEmail());
        existingRegistration.setDate(registration.getDate());
        existingRegistration.setNationality(registration.getNationality());
        existingRegistration.setContact(registration.getContact());
        existingRegistration.setAddress(registration.getAddress());
        existingRegistration.setResult1(registration.getResult1());
        existingRegistration.setResult2(registration.getResult2());
        return repository.save(existingRegistration);
    }
}
