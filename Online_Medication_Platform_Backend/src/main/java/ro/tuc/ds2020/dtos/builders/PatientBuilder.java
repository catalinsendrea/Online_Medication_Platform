package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.entities.Patient;

public class PatientBuilder {

    public PatientBuilder(){

    }

    public static PatientDTO toDTO(Patient patient){
        return new PatientDTO(patient.getId(), patient.getName(), patient.getBirth_date(), patient.getGender(), patient.getAddress(), patient.getMedical_record(), patient.getUsername(), patient.getPassword(), patient.getCaregiverId());
    }

    public static Patient toEntity(PatientDTO patientDTO){
        return new Patient(patientDTO.getId(), patientDTO.getName(), patientDTO.getBirth_date(), patientDTO.getGender(), patientDTO.getAddress(), patientDTO.getMedical_record(), patientDTO.getUsername(), patientDTO.getPassword(), patientDTO.getCaregiver_id());
    }

}
