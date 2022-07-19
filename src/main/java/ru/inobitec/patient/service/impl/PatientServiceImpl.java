package ru.inobitec.patient.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inobitec.patient.model.Patient;
import ru.inobitec.patient.repository.PatientMapper;
import ru.inobitec.patient.service.PatientService;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientMapper patientMapper;
    @Override
    public Patient getPatientById(Long id) {
        return patientMapper.getPatientById(id);
    }

    @Override
    public void addPatient(Patient newPatient) {
        patientMapper.addPatient(newPatient);
    }

    @Override
    public void updatePatient(Patient patientUpdate, Long id) {
        patientMapper.updatePatient(patientUpdate, id);
    }

    @Override
    public Patient getPatientByName(String firstName, String lastName, String birthday) {
        return patientMapper.getPatientByName(firstName, lastName);
    }

    @Override
    public void deleteOPatientById(Long id) {
        patientMapper.deletePatientById(id);
    }
}
