package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.ListOfMedicationDTO;
import ro.tuc.ds2020.entities.ListOfMedication;

public class ListOfMedicationBuilder {

    public ListOfMedicationBuilder(){

    }

    public static ListOfMedicationDTO toDTO(ListOfMedication listOfMedication){
        return new ListOfMedicationDTO(listOfMedication.getId(), listOfMedication.getName(), listOfMedication.getList_of_side_effects(), listOfMedication.getDosage());
    }

    public static ListOfMedication toEntity(ListOfMedicationDTO listOfMedicationDTO){
        return new ListOfMedication(listOfMedicationDTO.getId(), listOfMedicationDTO.getName(), listOfMedicationDTO.getList_of_side_effects(), listOfMedicationDTO.getDosage());
    }

}
