package ru.inobitec.patient.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.inobitec.patient.dto.PatientDTO;
import ru.inobitec.patient.mappers.PatientMapper;
import ru.inobitec.patient.model.PatientEntity;
import ru.inobitec.patient.repository.PatientRepository;

@Repository
@RequiredArgsConstructor
public class PatientRepositoryImpl implements PatientRepository {

    @Autowired
    private final PatientMapper patientMapper;

    @Override
    @Transactional
    public PatientDTO getPatientById(Long id) throws RuntimeException {
        return patientMapper.getPatientById(id).toDTO();
    }

    @Override
    @Transactional
    public PatientDTO getPatientByName(String firstName, String lastName, String birthday) throws RuntimeException {
        return patientMapper.getPatientByName(firstName, lastName).toDTO();
    }

    @Override
    @Transactional
    public PatientDTO addPatient(PatientDTO patient) throws RuntimeException {
        PatientEntity pat = patient.toEntity();
        patientMapper.addPatient(pat);
        return pat.toDTO();
    }

    @Override
    @Transactional
    public PatientDTO updatePatient(PatientDTO patient) throws RuntimeException {
        PatientEntity pat = patient.toEntity();
        patientMapper.updatePatient(pat, patient.getId());
        return pat.toDTO();
    }

    @Override
    @Transactional
    public void deleteOPatientById(Long id) throws RuntimeException {
        patientMapper.deletePatientById(id);
    }
}
