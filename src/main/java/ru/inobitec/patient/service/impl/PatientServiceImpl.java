package ru.inobitec.patient.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.inobitec.patient.dto.PatientDTO;
import ru.inobitec.patient.repository.PatientRepository;
import ru.inobitec.patient.service.PatientService;

@Service
@AllArgsConstructor
@Log4j2
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDTO getPatientById(Long id) {
        try {
            return patientRepository.getPatientById(id).toDTO();
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Long addPatient(PatientDTO patient) {
        try {
            return patientRepository.addPatient(patient.toEntity()).getId();
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void updatePatient(PatientDTO patient) {
        try {
            patientRepository.updatePatient(patient.toEntity());
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public PatientDTO getPatientByName(String firstName, String lastName, String birthday) {
        try {
            return patientRepository.getPatientByName(firstName, lastName, birthday).toDTO();
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteOPatientById(Long id) throws RuntimeException {
        try {
            patientRepository.deleteOPatientById(id);
        } catch (RuntimeException ex) {
            log.error(ex.getCause());
            throw new RuntimeException(ex);
        }
    }
}
