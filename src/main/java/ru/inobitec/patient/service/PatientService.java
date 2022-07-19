package ru.inobitec.patient.service;

import ru.inobitec.patient.model.Patient;

import java.util.Date;

public interface PatientService {
    public Patient getPatientById(Long id);
    public void addPatient(Patient newPatient);

    public void updatePatient(Patient patientUpdate, Long id);

    public Patient getPatientByName(String firstName, String lastName, String birthday);
    public void deleteOPatientById(Long id);
}
