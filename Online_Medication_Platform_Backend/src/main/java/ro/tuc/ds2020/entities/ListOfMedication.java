package ro.tuc.ds2020.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Table(name = "ListOfMedication")

public class ListOfMedication implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "list_of_side_effects", nullable = false)
    private String list_of_side_effects;

    @Column(name = "dosage", nullable = false)
    private int dosage;


    public ListOfMedication() {

    }

    public ListOfMedication(Integer id, String name, String list_of_side_effects, int dosage) {
        this.id = id;
        this.name = name;
        this.list_of_side_effects = list_of_side_effects;
        this.dosage = dosage;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getList_of_side_effects() {
        return list_of_side_effects;
    }

    public int getDosage() {
        return dosage;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setList_of_side_effects(String list_of_side_effects) {
        this.list_of_side_effects = list_of_side_effects;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

}
