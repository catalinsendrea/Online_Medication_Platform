package ro.tuc.ds2020.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "intake")

public class Intake implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "number_per_day", nullable = false)
    private Integer number;

    @Column(name = "start_take", nullable = false)
    private Integer start_take;

    @Column(name = "end_take", nullable = false)
    private Integer end_take;

    @Column(name = "start_date", nullable = false)
    private Date start_date;

    @Column(name = "end_date", nullable = false)
    private Date end_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient")
    private Patient patient;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tabela_legatura",
            joinColumns = { @JoinColumn(name = "medication_id") },
            inverseJoinColumns = { @JoinColumn(name = "intake_id") }
    )
    private Set<ListOfMedication> listOfMedication = new HashSet<>();


    public Intake() {

    }

    public Intake(Integer id, Integer number, Integer start_take, Integer end_take, Date start_date, Date end_date, Patient patient, Set<ListOfMedication> listOfMedication) {
        this.id = id;
        this.number = number;
        this.start_take = start_take;
        this.end_take = end_take;
        this.start_date = start_date;
        this.end_date = end_date;
        this.patient = patient;
        this.listOfMedication = listOfMedication;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Patient getPatient() {
        return patient;
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

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<ListOfMedication> getListOfMedication() {
        return listOfMedication;
    }

    public void setListOfMedication(Set<ListOfMedication> listOfMedication) {
        this.listOfMedication = listOfMedication;
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
