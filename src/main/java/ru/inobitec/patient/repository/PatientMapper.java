package ru.inobitec.patient.repository;

import org.apache.ibatis.annotations.Mapper;
import ru.inobitec.patient.model.Patient;



@Mapper
public interface PatientMapper {
    Patient getPatientById(Long id);

    void addPatient(Patient newPatient);

    void updatePatient(Patient patient, Long id);

    void deletePatientById(Long id);
}

