package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;
import ro.tuc.ds2020.entities.Patient;

import java.util.Date;

public class ActivityDTO extends RepresentationModel<ActivityDTO> {

    private Integer id;
    private Date start_date;
    private Date end_date;
    private String activity_label;
    private Integer patient_id;

    public ActivityDTO() {

    }

    public ActivityDTO(Date start_date, Date end_date, String activity_label, Integer patient_id) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.activity_label = activity_label;
        this.patient_id = patient_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getActivity_label() {
        return activity_label;
    }

    public void setActivity_label(String activity_label) {
        this.activity_label = activity_label;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }
}
