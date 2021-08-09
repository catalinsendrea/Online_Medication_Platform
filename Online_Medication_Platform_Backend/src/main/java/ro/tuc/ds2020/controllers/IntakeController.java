package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.IntakeDTO;
import ro.tuc.ds2020.dtos.ListOfMedicationDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.dtos.builders.IntakeBuilder;
import ro.tuc.ds2020.dtos.builders.ListOfMedicationBuilder;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Intake;
import ro.tuc.ds2020.entities.ListOfMedication;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.services.IntakeService;
import ro.tuc.ds2020.services.ListOfMedicationService;
import ro.tuc.ds2020.services.PatientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/intake")

public class IntakeController {

    private final IntakeService intakeService;

    @Autowired
    public IntakeController(IntakeService intakeService){
        this.intakeService = intakeService;
    }


    @PostMapping()
    public ResponseEntity<Integer> insertIntake(@Valid @RequestBody IntakeDTO intakeDTO) {
        Integer intakeId = intakeService.insertIntake(intakeDTO);
        return new ResponseEntity<>(intakeId, HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<List<IntakeDTO>> getIntakes() {
        List<IntakeDTO> dtos = intakeService.findIntakes();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
