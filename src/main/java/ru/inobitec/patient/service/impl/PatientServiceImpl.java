package ru.inobitec.patient.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inobitec.patient.dto.PatientDTO;
import ru.inobitec.patient.repository.PatientRepository;
import ru.inobitec.patient.service.PatientService;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    @Override
    public PatientDTO getPatientById(Long id) throws RuntimeException {
        return patientRepository.getPatientById(id);
    }

    @Override
    public Long addPatient(PatientDTO patient) throws RuntimeException {
        return patientRepository.addPatient(patient).getId();
    }

    @Override
    public void updatePatient(PatientDTO patient) throws RuntimeException {
        patientRepository.updatePatient(patient);
    }

    @Override
    public PatientDTO getPatientByName(String firstName, String lastName, String birthday) throws RuntimeException {
        return patientRepository.getPatientByName(firstName, lastName, birthday);
    }

    @Override
    public void deleteOPatientById(Long id) throws RuntimeException {
        patientRepository.deleteOPatientById(id);
    }
}
