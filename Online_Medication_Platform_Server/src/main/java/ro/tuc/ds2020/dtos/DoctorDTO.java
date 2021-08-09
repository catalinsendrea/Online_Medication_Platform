package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;


public class DoctorDTO extends RepresentationModel<DoctorDTO> {

    private Integer id;
    private String name;
    private String username;
    private String password;

    public DoctorDTO() {

    }

    public DoctorDTO(Integer id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
