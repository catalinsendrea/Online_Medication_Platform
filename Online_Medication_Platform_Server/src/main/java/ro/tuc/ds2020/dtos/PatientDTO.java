package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.sql.Date;

public class PatientDTO extends RepresentationModel<PatientDTO> {

    private Integer id;
    private String name;
    private Date birth_date;
    private String gender;
    private String address;
    private String medical_record;
    private Integer caregiver_id;
    private String username;
    private String password;

    public PatientDTO() {

    }

    public PatientDTO(Integer id, String name, Date birth_date, String gender, String address, String medical_record, String username, String password, Integer caregiver_id) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
        this.medical_record = medical_record;
        this.username = username;
        this.password = password;
        this.caregiver_id = caregiver_id;
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

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedical_record() {
        return medical_record;
    }

    public void setMedical_record(String medical_record) {
        this.medical_record = medical_record;
    }

    public Integer getCaregiver_id() {
        return caregiver_id;
    }

    public void setCaregiver_id(Integer caregiver_id) {
        this.caregiver_id = caregiver_id;
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
}
