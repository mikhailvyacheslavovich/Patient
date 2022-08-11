package ru.inobitec.patient.repository;

import ru.inobitec.patient.dto.PatientDTO;

public interface PatientRepository {
    PatientDTO getPatientById(Long id);

    PatientDTO getPatientByName(String firstName, String lastName, String birthday);

    PatientDTO addPatient(PatientDTO patient);

    PatientDTO updatePatient(PatientDTO patient);

    void deleteOPatientById(Long id);
}
