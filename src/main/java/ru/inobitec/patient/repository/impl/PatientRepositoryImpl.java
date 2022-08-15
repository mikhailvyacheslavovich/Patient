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
        try {
            return patientMapper.getPatientById(id);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }

    @Override
    @Transactional
    public PatientEntity getPatientByName(String firstName, String lastName, String birthday) {
        try {
            return patientMapper.getPatientByName(firstName, lastName, birthday);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }

    @Override
    @Transactional
    public PatientEntity addPatient(PatientEntity patient) {
        try {
            patientMapper.addPatient(patient);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
        return patient;
    }

    @Override
    @Transactional
    public PatientEntity updatePatient(PatientEntity patient) {
        try {
            patientMapper.updatePatient(patient, patient.getId());
            return patient;
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }

    @Override
    @Transactional
    public void deleteOPatientById(Long id) throws RuntimeException {
        try {
            patientMapper.deletePatientById(id);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }
}
