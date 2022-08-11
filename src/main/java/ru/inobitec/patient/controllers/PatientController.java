package ru.inobitec.patient.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.inobitec.patient.dto.PatientDTO;
import ru.inobitec.patient.service.PatientService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patient/{id}")
    public PatientDTO getPatientById(@PathVariable("id") Long id) {
        try{
            return patientService.getPatientById(id);
        }catch (RuntimeException ex){
            return null;
        }
    }

    @GetMapping("/patientName")
    public PatientDTO getPatientByName(@PathParam("firstName") String firstName,
                                          @PathParam("lastName") String lastName,
                                          @PathParam("birthday") String birthday) {
        try{
            return patientService.getPatientByName(firstName, lastName, birthday);
        }catch (RuntimeException ex){
            return null;
        }
    }

    @PostMapping("/patient")
    public Long addPatient(@RequestBody PatientDTO patient) {
        try{
            return patientService.addPatient(patient);
        }catch(RuntimeException ex){
            return null;
        }
    }

    @PutMapping("/patient")
    public String updatePatient(@RequestBody PatientDTO patientUpdate) {
        try{
            patientService.updatePatient(patientUpdate);
            return "Patient updated";
        } catch (RuntimeException ex){
            return "Error while updating patient";
        }
    }

    @DeleteMapping("/patient/{id}")
    public String deletePatientById(@PathVariable("id") Long id) {
        try{
            patientService.deleteOPatientById(id);
            return "Patient deleted";
        }catch(RuntimeException ex){
            return "Error while deleting patient";
        }
    }
}
