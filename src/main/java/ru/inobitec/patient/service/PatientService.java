package ru.inobitec.patient.service;

import ru.inobitec.patient.model.Patient;

import java.util.Date;

public interface PatientService {
    Patient getPatientById(Long id);
    Long addPatient(Patient patient);
    void updatePatient(Patient patientUpdate, Long id);
    Patient getPatientByName(String firstName, String lastName, String birthday);
    void deleteOPatientById(Long id);
}
