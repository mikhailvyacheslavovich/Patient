package ru.inobitec.patient.service;

import ru.inobitec.patient.model.Patient;

public interface PatientService {
    public Patient getPatientById(Long id);
    public void addPatient(Patient newPatient);

    public void updatePatient(Patient patientUpdate, Long id);

    public Patient getPatientByName(String name);
    public void deleteOPatientById(Long id);
}
