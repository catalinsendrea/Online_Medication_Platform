package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

public class ListOfMedicationDTO extends RepresentationModel<ListOfMedicationDTO> {

    private Integer id;
    private String name;
    private String list_of_side_effects;
    private int dosage;

    public ListOfMedicationDTO() {

    }

    public ListOfMedicationDTO(Integer id, String name, String list_of_side_effects, int dosage) {
        this.id = id;
        this.name = name;
        this.list_of_side_effects = list_of_side_effects;
        this.dosage = dosage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getList_of_side_effects() {
        return list_of_side_effects;
    }

    public void setList_of_side_effects(String list_of_side_effects) {
        this.list_of_side_effects = list_of_side_effects;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
}
