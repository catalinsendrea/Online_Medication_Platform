package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.entities.Doctor;

public class DoctorBuilder {

    public DoctorBuilder() {

    }

    public static DoctorDTO toDTO(Doctor doctor){
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getUsername(), doctor.getPassword());
    }

    public static Doctor toEntity(DoctorDTO doctorDTO){
        return new Doctor(doctorDTO.getName(), doctorDTO.getUsername(), doctorDTO.getPassword());
    }
}
