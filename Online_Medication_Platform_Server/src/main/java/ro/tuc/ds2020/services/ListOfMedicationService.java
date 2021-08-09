package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.ListOfMedicationDTO;
import ro.tuc.ds2020.dtos.builders.ListOfMedicationBuilder;
import ro.tuc.ds2020.entities.Intake;
import ro.tuc.ds2020.entities.ListOfMedication;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.IntakeRepository;
import ro.tuc.ds2020.repositories.ListOfMedicationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListOfMedicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListOfMedicationService.class);
    private final ListOfMedicationRepository listOfMedicationRepository;

    @Autowired
    public ListOfMedicationService(ListOfMedicationRepository listOfMedicationRepository) {
        this.listOfMedicationRepository = listOfMedicationRepository;
    }


    public List<ListOfMedicationDTO> findMedications() {
        List<ListOfMedication> medicationList = listOfMedicationRepository.findAll();
        return medicationList.stream()
                .map(ListOfMedicationBuilder::toDTO)
                .collect(Collectors.toList());
    }

    public ListOfMedicationDTO findMedicationById(Integer id) {
        Optional<ListOfMedication> opt = listOfMedicationRepository.findById(id);
        if (!opt.isPresent()) {
            LOGGER.error("Medication with id {} was not found in db", id);
            throw new ResourceNotFoundException(ListOfMedication.class.getSimpleName() + " with id: " + id);
        }
        return ListOfMedicationBuilder.toDTO(opt.get());
    }

    public void deleteMedication(Integer id){
        ListOfMedication medication = listOfMedicationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Medication with the id: " + id + "doesn't exist."));
        listOfMedicationRepository.delete(medication);
    }

    public Integer insertMedication(ListOfMedicationDTO listOfMedicationDTO) {
        ListOfMedication listOfMedication = ListOfMedicationBuilder.toEntity(listOfMedicationDTO);
        listOfMedication = listOfMedicationRepository.save(listOfMedication);
        LOGGER.debug("Medication with id {} was inserted in db", listOfMedication.getId());
        return listOfMedication.getId();
    }

    public Integer updateMedication(Integer id, ListOfMedicationDTO listOfMedicationDTO) {
        Optional<ListOfMedication> opt = listOfMedicationRepository.findById(id);
        if (!opt.isPresent()) {
            LOGGER.error("Medication with id {} was not found in db", id);
            throw new ResourceNotFoundException(ListOfMedication.class.getSimpleName() + " with id: " + id);
        }

        ListOfMedication medication = opt.get();
        medication.setName(listOfMedicationDTO.getName());
        medication.setList_of_side_effects(listOfMedicationDTO.getList_of_side_effects());
        medication.setDosage(listOfMedicationDTO.getDosage());
        medication = listOfMedicationRepository.save(medication);
        LOGGER.debug("Medication with id {} was updated in db", medication.getId());
        return medication.getId();
    }
}
