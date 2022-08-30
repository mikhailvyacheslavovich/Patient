package ru.inobitec.patient.repository.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.inobitec.patient.mappers.PatientMapper;
import ru.inobitec.patient.model.PatientEntity;
import ru.inobitec.patient.repository.PatientRepository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PatientRepositoryImpl implements PatientRepository {
    private final PatientMapper patientMapper;

    @Override
    @Transactional
    public PatientEntity getPatientById(Long id) {
        return patientMapper.getPatientById(id);
    }

    @Override
    @Transactional
    public PatientEntity getPatientByName(String firstName, String lastName, String midName, String birthday) {
        return patientMapper.getPatientByName(firstName, lastName, midName, birthday);
    }

    @Override
    @Transactional
    public PatientEntity addPatient(PatientEntity patient) {
        patientMapper.addPatient(patient);
        return patient;
    }

    @Override
    @Transactional
    public PatientEntity updatePatient(PatientEntity patient) {
        patientMapper.updatePatient(patient, patient.getId());
        return patient;
    }

    @Override
    @Transactional
    public Long deleteOPatientById(Long id) {
        return patientMapper.deletePatientById(id);
    }
}
