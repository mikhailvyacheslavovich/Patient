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
}
