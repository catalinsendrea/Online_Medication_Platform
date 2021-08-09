package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Intake;
import ro.tuc.ds2020.entities.ListOfMedication;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient assignPatient(Caregiver caregiver, Patient patient) {
        patient.setCaregiver(caregiver);
        patientRepository.save(patient);
        LOGGER.debug("Patient with id {} was assigned to a caregiver", patient.getId());
        return patient;
    }


    public List<PatientDTO> findPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream()
                .map(PatientBuilder::toDTO)
                .collect(Collectors.toList());
    }


    public PatientDTO findPatientById(Integer id) {
        Optional<Patient> opt = patientRepository.findById(id);
        if (!opt.isPresent()) {
            LOGGER.error("Patient with id {} was not found in db", id);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
        }
        return PatientBuilder.toDTO(opt.get());
    }


    public void deletePatient(Integer id){
        PatientDTO patientDTO = this.findPatientById(id);
        Patient patient = PatientBuilder.toEntity(patientDTO);
        patientRepository.deleteById(id);
    }


    public Integer insertPatient(PatientDTO patientDTO) {
        Patient patient = PatientBuilder.toEntity(patientDTO);
        patient = patientRepository.save(patient);
        LOGGER.debug("Patient with id {} was inserted in db", patient.getId());
        return patient.getId();
    }


    public Integer updatePatient(Integer id, PatientDTO patientDTO) {
        Optional<Patient> opt = patientRepository.findById(id);
        if (!opt.isPresent()) {
            LOGGER.error("Patient with id {} was not found in db", id);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
        }

        Patient patient = opt.get();
        patient.setName(patientDTO.getName());
        patient.setBirth_date(patientDTO.getBirth_date());
        patient.setGender(patientDTO.getGender());
        patient.setAddress(patientDTO.getAddress());
        patient.setMedical_record(patientDTO.getMedical_record());
        patient = patientRepository.save(patient);
        LOGGER.debug("Patient with id {} was updated in db", patient.getId());
        return patient.getId();
    }
}
