package ru.inobitec.patient.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ru.inobitec.patient.dto.PatientDTO;
import ru.inobitec.patient.service.PatientService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Log4j2
public class PatientController {

    private static final String UPDATE_PATIENT_POSITIVE = "Patient updated";

    private static final String UPDATE_PATIENT_NEGATIVE = "Unable to update patient by id ";

    private static final String DELETE_PATIENT_POSITIVE = "Patient deleted";

    private static final String DELETE_PATIENT_NEGATIVE = "Unable to get patient by id ";


    private final PatientService patientService;

    @GetMapping("/patient/{id}")
    public PatientDTO getPatientById(@PathVariable("id") Long id) {
        try {
            return patientService.getPatientById(id);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            return null;
        }
    }

    @GetMapping("/patientName")
    public PatientDTO getPatientByName(@PathParam("firstName") String firstName,
                                       @PathParam("lastName") String lastName,
                                       @PathParam("midName") String midName,
                                       @PathParam("birthday") String birthday) {
        try {
            return patientService.getPatientByName(firstName, lastName, midName, birthday);
        } catch (RuntimeException ex) {
            log.info(ex.getCause());
            return null;
        }
    }

    @PostMapping("/patient")
    public Long addPatient(@RequestBody PatientDTO patient) {
        try {
            return patientService.addPatient(patient);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            return null;
        }
    }

    @PutMapping("/patient")
    public String updatePatient(@RequestBody PatientDTO patient) {
        try {
            patientService.updatePatient(patient);
            return UPDATE_PATIENT_POSITIVE;
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            return UPDATE_PATIENT_NEGATIVE + patient.getId();
        }
    }

    @DeleteMapping("/patient/{id}")
    public String deletePatientById(@PathVariable("id") Long id) {
        try {
            patientService.deletePatientById(id);
            return DELETE_PATIENT_POSITIVE;
        } catch (RuntimeException ex) {
            return DELETE_PATIENT_NEGATIVE + id;
        }
    }
}
