package ru.inobitec.patient.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PatientNotFoundException extends RuntimeException{

}
