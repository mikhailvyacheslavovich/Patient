package ru.inobitec.patient.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.inobitec.patient.dto.PatientDTO;

import java.util.Date;

import static ru.inobitec.patient.util.StringConstants.DATA_PATTERN;

@Data
@RequiredArgsConstructor
public class PatientEntity {
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

    public PatientDTO toDTO() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setAddress(getAddress());
        patientDTO.setBirthday(getBirthday());
        patientDTO.setEmail(getEmail());
        patientDTO.setFirstName(getFirstName());
        patientDTO.setGenderId(getGenderId());
        patientDTO.setId(getId());
        patientDTO.setLastName(getLastName());
        patientDTO.setPhone(getPhone());
        patientDTO.setMidName(getMidName());
        return patientDTO;
    }
}
