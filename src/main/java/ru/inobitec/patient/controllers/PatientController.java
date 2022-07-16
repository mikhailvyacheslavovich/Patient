package ru.inobitec.patient.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inobitec.patient.model.Patient;
import ru.inobitec.patient.service.PatientService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patient/{id}")
    public Patient getOrderById(@PathVariable("id") Long id) {
        return patientService.getPatientById(id);
    }
}
