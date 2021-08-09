package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.services.CaregiverService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/caregiver")

public class CaregiverController {

    private final CaregiverService caregiverService;

    @Autowired
    public CaregiverController(CaregiverService caregiverService){
        this.caregiverService = caregiverService;
    }

    @GetMapping()
    public ResponseEntity<List<CaregiverDTO>> getCargivers() {
        List<CaregiverDTO> dtos = caregiverService.findCaregivers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CaregiverDTO> getCaregiverById(@PathVariable("id") Integer id) {
        CaregiverDTO dto = caregiverService.findCaregiverById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCaregiver(@PathVariable Integer id){
        caregiverService.deleteCaregiver(id);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertCaregiver(@Valid @RequestBody CaregiverDTO caregiverDTO) {
        Integer caregiverId = caregiverService.insertCaregiver(caregiverDTO);
        return new ResponseEntity<>(caregiverId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Integer> updateCaregiver(@PathVariable("id") Integer caregiverId, @Valid @RequestBody CaregiverDTO caregiverDTO) {
        Integer caregiverID = caregiverService.updateCaregiver(caregiverId, caregiverDTO);
        return new ResponseEntity<>(caregiverID, HttpStatus.OK);
    }

}
