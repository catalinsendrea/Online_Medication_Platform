package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.IntakeDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.dtos.builders.IntakeBuilder;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Intake;
import ro.tuc.ds2020.entities.ListOfMedication;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.IntakeRepository;
import ro.tuc.ds2020.repositories.ListOfMedicationRepository;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service

public class IntakeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntakeService.class);

    private final IntakeRepository intakeRepository;


    @Autowired
    public IntakeService(IntakeRepository intakeRepository) {
        this.intakeRepository = intakeRepository;
    }

    public Integer insertIntake(IntakeDTO intakeDTO) {
        Intake intake = IntakeBuilder.toEntity(intakeDTO);
        intake = intakeRepository.save(intake);
        LOGGER.debug("Intake with id {} was inserted in db", intake.getId());
        return intake.getId();
    }


    public List<IntakeDTO> findIntakes() {
        List<Intake> intakeList = intakeRepository.findAll();
        return intakeList.stream()
                .map(IntakeBuilder::toDTO)
                .collect(Collectors.toList());
    }

}
