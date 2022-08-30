package ru.inobitec.patient.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.inobitec.patient.dto.PatientDTO;
import ru.inobitec.patient.exceptions.PatientNotFoundException;
import ru.inobitec.patient.model.PatientEntity;
import ru.inobitec.patient.repository.PatientRepository;
import ru.inobitec.patient.service.PatientService;

@Service
@AllArgsConstructor
@Log4j2
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDTO getPatientById(Long id) {
        PatientEntity patient = patientRepository.getPatientById(id);
        if (patient == null)
            throw new PatientNotFoundException();
        else
            return patient.toDTO();
    }

    @Override
    public Long addPatient(PatientDTO patient) {
        return patientRepository.addPatient(patient.toEntity()).getId();
    }

    @Override
    public void updatePatient(PatientDTO patient) {
        PatientEntity patientEntity = patientRepository.updatePatient(patient.toEntity());
        if (patientEntity == null)
            throw new PatientNotFoundException();

    }

    @Override
    public PatientDTO getPatientByName(String firstName, String lastName, String midName, String birthday) {
        PatientEntity patient = patientRepository.getPatientByName(firstName, lastName, midName, birthday);
        if (patient == null)
            throw new PatientNotFoundException();
        else
            return patient.toDTO();
    }

    @Override
    public void deletePatientById(Long id) throws RuntimeException {
        Long quantity = patientRepository.deleteOPatientById(id);
        if (quantity == 0)
            throw new PatientNotFoundException();
    }
}
