package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;
import ro.tuc.ds2020.entities.Patient;

import java.sql.Date;
import java.util.Set;

public class CaregiverDTO extends RepresentationModel<CaregiverDTO> {

    private Integer id;
    private String name;
    private Date birth_date;
    private String gender;
    private String address;
    private String username;
    private String password;
    private Set<Patient> patientList;

    public CaregiverDTO() {

    }

    public CaregiverDTO(Integer id, String name, Date birth_date, String gender, String address, String username, String password, Set<Patient> patientList) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
        this.username = username;
        this.password = password;
        this.patientList = patientList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(Set<Patient> patientList) {
        this.patientList = patientList;
    }
}
