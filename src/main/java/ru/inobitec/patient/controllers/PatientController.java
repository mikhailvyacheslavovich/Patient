package ru.inobitec.patient.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inobitec.patient.dto.PatientDTO;
import ru.inobitec.patient.exceptions.PatientNotFoundException;
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

    private static final String NOT_EXIST_PATIENT_FOR_DELETE = "Can not find patient with id = ";

    private static final String NOT_EXIST_PATIENT_FOR_UPDATE = "Can not find patient for update with id = ";

    private static final String PATIENT_CREATED_NEGATIVE = "Unable to create patient ";
    private final PatientService patientService;

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") Long id) {
        try {
            PatientDTO patientDTO = patientService.getPatientById(id);
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        } catch (PatientNotFoundException pEx) {
            log.error(pEx.getCause());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patientName")
    public ResponseEntity<PatientDTO> getPatientByName(@PathParam("firstName") String firstName,
                                                       @PathParam("lastName") String lastName,
                                                       @PathParam("midName") String midName,
                                                       @PathParam("birthday") String birthday) {
        try {
            PatientDTO patientDTO = patientService.getPatientByName(firstName, lastName, midName, birthday);
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        } catch (PatientNotFoundException pEx) {
            log.error(pEx.getCause());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/patient")
    public ResponseEntity<Long> addPatient(@RequestBody PatientDTO patient) {
        try {
            return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.OK);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<String> updatePatient(@RequestBody PatientDTO patient, @PathVariable("id") Long id) {
        try {
            patientService.updatePatient(patient);
            return new ResponseEntity<>(UPDATE_PATIENT_POSITIVE, HttpStatus.OK);
        } catch (PatientNotFoundException pEx) {
            log.error(pEx.getCause());
            return new ResponseEntity<>(NOT_EXIST_PATIENT_FOR_UPDATE + patient.getId(), HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(UPDATE_PATIENT_NEGATIVE + patient.getId(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable("id") Long id) {
        try {
            patientService.deletePatientById(id);
            return new ResponseEntity<>(DELETE_PATIENT_POSITIVE, HttpStatus.OK);
        } catch (PatientNotFoundException pEx) {
            log.error(pEx.getCause());
            return new ResponseEntity<>(NOT_EXIST_PATIENT_FOR_DELETE + id, HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            return new ResponseEntity<>(DELETE_PATIENT_NEGATIVE + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
