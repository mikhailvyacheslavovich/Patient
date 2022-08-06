package ru.inobitec.patient.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inobitec.patient.model.Patient;
import ru.inobitec.patient.service.PatientService;

import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patient/{id}")
    public Patient getOrderById(@PathVariable("id") Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patientName")
    public Patient getPatientByName(@PathParam("firstName") String firstName,
                                    @PathParam("lastName") String lastName,
                                    @PathParam("birthday") String birthday) {
        return patientService.getPatientByName(firstName, lastName, birthday);
    }

    @PostMapping("/patient")
    public String addPatient(@RequestBody Patient newPatient) {
        patientService.addPatient(newPatient);
        return "Patient was created";
    }

    @PutMapping("/updatePatient/{id}")
    public String updatePatient(@RequestBody Patient patientUpdate,
                                @PathVariable("id") Long id) {
        patientService.updatePatient(patientUpdate, id);
        return "Patient updated";
    }

    @DeleteMapping("/deletePatient/{id}")
    public String deletePatientById(@PathVariable("id") Long id) {
        patientService.deleteOPatientById(id);
        return "Patient deleted";
    }
}
