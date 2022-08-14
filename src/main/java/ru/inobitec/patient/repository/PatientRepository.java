package ru.inobitec.patient.repository;

import ru.inobitec.patient.model.PatientEntity;

public interface PatientRepository {
    PatientEntity getPatientById(Long id);

    PatientEntity getPatientByName(String firstName, String lastName, String birthday);

    PatientEntity addPatient(PatientEntity patient);

    PatientEntity updatePatient(PatientEntity patient);

    void deleteOPatientById(Long id);
}
