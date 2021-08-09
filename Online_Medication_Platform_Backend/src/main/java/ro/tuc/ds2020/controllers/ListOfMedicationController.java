package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.ListOfMedicationDTO;
import ro.tuc.ds2020.services.ListOfMedicationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medication")

public class ListOfMedicationController {

    private final ListOfMedicationService listOfMedicationService;

    @Autowired
    public ListOfMedicationController(ListOfMedicationService listOfMedicationService){
        this.listOfMedicationService = listOfMedicationService;
    }

    @GetMapping()
    public ResponseEntity<List<ListOfMedicationDTO>> getMedications() {
        List<ListOfMedicationDTO> dtos = listOfMedicationService.findMedications();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ListOfMedicationDTO> getMedicationById(@PathVariable("id") Integer id) {
        ListOfMedicationDTO dto = listOfMedicationService.findMedicationById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable Integer id){
        listOfMedicationService.deleteMedication(id);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertMedication(@Valid @RequestBody ListOfMedicationDTO listOfMedicationDTO) {
        Integer medicationId = listOfMedicationService.insertMedication(listOfMedicationDTO);
        return new ResponseEntity<>(medicationId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Integer> updateMedication(@PathVariable("id") Integer medicationId, @Valid @RequestBody ListOfMedicationDTO listOfMedicationDTO) {
        Integer medicationID = listOfMedicationService.updateMedication(medicationId, listOfMedicationDTO);
        return new ResponseEntity<>(medicationID, HttpStatus.OK);
    }
}
