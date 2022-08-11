package ru.inobitec.patient.mappers;

import org.apache.ibatis.annotations.Mapper;
import ru.inobitec.patient.model.PatientEntity;


@Mapper
public interface PatientMapper {
    PatientEntity getPatientById(Long id);

    PatientEntity getPatientByName(String firstName, String lastName);

    Long addPatient(PatientEntity patient);

    void updatePatient(PatientEntity patient, Long id);

    void deletePatientById(Long id);
}

