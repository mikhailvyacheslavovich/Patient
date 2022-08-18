package ru.inobitec.patient.service;

import ru.inobitec.patient.dto.PatientDTO;

public interface PatientService {
    PatientDTO getPatientById(Long id);

    Long addPatient(PatientDTO patient);

    void updatePatient(PatientDTO patient);

    PatientDTO getPatientByName(String firstName, String lastName, String birthday);

    void deletePatientById(Long id);
}
