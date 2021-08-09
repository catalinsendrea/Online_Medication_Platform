package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.CaregiverRepository;



import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CaregiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaregiverService.class);
    private final CaregiverRepository caregiverRepository;

    @Autowired
    public CaregiverService(CaregiverRepository caregiverRepository) {
        this.caregiverRepository = caregiverRepository;
    }

    public List<CaregiverDTO> findCaregivers() {
        List<Caregiver> caregiverList = caregiverRepository.findAll();
        return caregiverList.stream()
                .map(CaregiverBuilder::toDTO)
                .collect(Collectors.toList());
    }

    public CaregiverDTO findCaregiverById(Integer id) {
        Optional<Caregiver> opt = caregiverRepository.findById(id);
        if (!opt.isPresent()) {
            LOGGER.error("Caregiver with id {} was not found in db", id);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + id);
        }
        return CaregiverBuilder.toDTO(opt.get());
    }

    public void deleteCaregiver(Integer id){
        CaregiverDTO caregiverDTO = this.findCaregiverById(id);
        Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDTO);
        Set<Patient> patientSet = caregiver.getPatientList();
        for(Patient patient: patientSet){
            patient.setCaregiver(null);
        }
        caregiverRepository.deleteById(id);


    }

    public Integer insertCaregiver(CaregiverDTO caregiverDTO) {
        Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDTO);
        caregiver = caregiverRepository.save(caregiver);
        LOGGER.debug("Caregiver with id {} was inserted in db", caregiver.getId());
        return caregiver.getId();
    }

    public Integer updateCaregiver(Integer id, CaregiverDTO caregiverDTO) {
        Optional<Caregiver> opt = caregiverRepository.findById(id);
        if (!opt.isPresent()) {
            LOGGER.error("Caregiver with id {} was not found in db", id);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + id);
        }

        Caregiver caregiver = opt.get();
        caregiver.setName(caregiverDTO.getName());
        caregiver.setBirth_date(caregiverDTO.getBirth_date());
        caregiver.setGender(caregiverDTO.getGender());
        caregiver.setAddress(caregiverDTO.getAddress());
        caregiver.setPatientList(caregiverDTO.getPatientList());
        caregiver = caregiverRepository.save(caregiver);
        LOGGER.debug("Caregiver with id {} was updated in db", caregiver.getId());
        return caregiver.getId();
    }
}
