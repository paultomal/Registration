package com.paul.registrationform.controller;

import com.paul.registrationform.entity.Registration;
import com.paul.registrationform.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.ObjectError;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RegistrationController {

    private final RegistrationService service;
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }
    @PostMapping("/addRegistration")
    public ResponseEntity<?> addRegistration(@Valid @RequestBody Registration
                                                                    registration, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(bindingResult
                            .getAllErrors()
                            .stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining()));

        }
        return new ResponseEntity<>(service.saveRegistration(registration), HttpStatus.OK);
    }
    @PostMapping("/addRegistrations")
    public List<Registration> addRegistrations(@Valid @RequestBody List<Registration> registrations){
        return  service.saveAllRegistrations(registrations);
    }
    @GetMapping("/registrations")
    public List<Registration> findAllRegistration(){
        return service.getAllRegistrations();
    }
    @GetMapping("/registration/{firstName}")
    public Registration findRegistrationByFirstName(@PathVariable String firstName){
        return service.getRegistrationByFirstName(firstName);
    }
    @GetMapping("/registration/s/{lastName}")
    public Registration findRegistrationByLastName(@PathVariable String lastName){
        return service.getRegistrationByLastName(lastName);
    }
    @PutMapping("/update")
    public Registration updateRegistration(@Valid @RequestBody Registration registration){
        return service.updateRegistration(registration);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRegistration(@PathVariable int id){
        return service.deleteRegistration(id);
    }




}
