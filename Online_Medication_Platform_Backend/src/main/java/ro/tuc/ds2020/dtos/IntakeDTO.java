package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;
import ro.tuc.ds2020.entities.ListOfMedication;
import ro.tuc.ds2020.entities.Patient;

import java.sql.Date;
import java.util.Set;

public class IntakeDTO extends RepresentationModel<IntakeDTO> {

    private Integer id;
    private Integer number;
    private Integer start_take;
    private Integer end_take;
    private Date start_date;
    private Date end_date;
    private Patient patient;
    private Set<ListOfMedication> listOfMedication;

    public IntakeDTO() {

    }

    public IntakeDTO(Integer id, Integer number, Integer start_take, Integer end_take, Date start_date, Date end_date, Patient patient, Set<ListOfMedication> listOfMedication) {
        this.id = id;
        this.number = number;
        this.start_take = start_take;
        this.end_take = end_take;
        this.start_date = start_date;
        this.end_date = end_date;
        this.patient = patient;
        this.listOfMedication = listOfMedication;
    }

    public Integer getId() {
        return id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<ListOfMedication> getListOfMedication() {
        return listOfMedication;
    }

    public void setListOfMedication(Set<ListOfMedication> listOfMedication) {
        this.listOfMedication = listOfMedication;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getStart_take() {
        return start_take;
    }

    public void setStart_take(Integer start_take) {
        this.start_take = start_take;
    }

    public Integer getEnd_take() {
        return end_take;
    }

    public void setEnd_take(Integer end_take) {
        this.end_take = end_take;
    }
}
