package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.entities.Caregiver;

public class CaregiverBuilder {

    public CaregiverBuilder() {

    }

    public static CaregiverDTO toDTO(Caregiver caregiver){
        return new CaregiverDTO(caregiver.getId(), caregiver.getName(), caregiver.getBirth_date(), caregiver.getGender(), caregiver.getAddress(), caregiver.getUsername(), caregiver.getPassword(), caregiver.getPatientList());
    }

    public static Caregiver toEntity(CaregiverDTO caregiverDTO){
        return new Caregiver(caregiverDTO.getId(), caregiverDTO.getName(), caregiverDTO.getBirth_date(), caregiverDTO.getGender(), caregiverDTO.getAddress(), caregiverDTO.getUsername(), caregiverDTO.getPassword(), caregiverDTO.getPatientList());
    }

}
