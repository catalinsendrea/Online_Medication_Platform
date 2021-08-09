package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.IntakeDTO;
import ro.tuc.ds2020.entities.Intake;

public class IntakeBuilder {

    public IntakeBuilder() {

    }

    public static IntakeDTO toDTO(Intake intake){
        return new IntakeDTO(intake.getId(), intake.getNumber(), intake.getStart_take(), intake.getEnd_take(), intake.getStart_date(), intake.getEnd_date(), intake.getPatient(), intake.getListOfMedication());
    }

    public static Intake toEntity(IntakeDTO intakeDTO){
        return new Intake(intakeDTO.getId(), intakeDTO.getNumber(), intakeDTO.getStart_take(), intakeDTO.getEnd_take(), intakeDTO.getStart_date(), intakeDTO.getEnd_date(), intakeDTO.getPatient(), intakeDTO.getListOfMedication());
    }

}
