package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.services.CaregiverService;
import ro.tuc.ds2020.services.PatientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")

public class PatientController {

    private final PatientService patientService;
    private final CaregiverService caregiverService;

    @Autowired
    public PatientController(PatientService patientService, CaregiverService caregiverService){
        this.patientService = patientService;
        this.caregiverService = caregiverService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientDTO>> getPatients() {
        List<PatientDTO> dtos = patientService.findPatients();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") Integer id) {
        PatientDTO dto = patientService.findPatientById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Integer id){
        patientService.deletePatient(id);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertPatient(@Valid @RequestBody PatientDTO patientDTO) {
        Integer patientId = patientService.insertPatient(patientDTO);
        Integer caregiverId = patientDTO.getCaregiver_id();
        CaregiverDTO caregiverDTO = caregiverService.findCaregiverById(caregiverId);
        Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDTO);
        Patient patient = PatientBuilder.toEntity(patientDTO);
        patientService.assignPatient(caregiver,patient);
        return new ResponseEntity<>(patientId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Integer> updatePatient(@PathVariable("id") Integer patientId, @Valid @RequestBody PatientDTO patientDTO) {
        Integer patientID = patientService.updatePatient(patientId, patientDTO);
        return new ResponseEntity<>(patientID, HttpStatus.OK);
    }
}
