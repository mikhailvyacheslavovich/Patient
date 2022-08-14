package ru.inobitec.patient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.inobitec.patient.model.PatientEntity;

import java.util.Date;

import static ru.inobitec.patient.util.StringConstants.DATA_PATTERN;

@Data
@RequiredArgsConstructor
public class PatientDTO {
    private Long id;
    private String firstName;
    private String midName;
    private String lastName;
    private Byte genderId;
    @DateTimeFormat(pattern = DATA_PATTERN)
    @JsonFormat(locale = "ru", timezone = "GMT+3", pattern = DATA_PATTERN)
    private Date birthday;
    private String phone;
    private String email;
    private String address;

    public PatientEntity toEntity() {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setAddress(getAddress());
        patientEntity.setBirthday(getBirthday());
        patientEntity.setEmail(getEmail());
        patientEntity.setFirstName(getFirstName());
        patientEntity.setId(getId());
        patientEntity.setGenderId(getGenderId());
        patientEntity.setLastName(getLastName());
        patientEntity.setMidName(getMidName());
        patientEntity.setPhone(getPhone());
        return patientEntity;
    }
}
