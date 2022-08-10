package ru.inobitec.patient.repository;

import org.apache.ibatis.annotations.Mapper;
import ru.inobitec.patient.model.Patient;

import java.util.Date;


@Mapper
public interface PatientMapper {
    Patient getPatientById(Long id);

    Patient getPatientByName(String firstName, String lastName);

    Long addPatient(Patient patient);

    void updatePatient(Patient patient, Long id);

    void deletePatientById(Long id);
}

