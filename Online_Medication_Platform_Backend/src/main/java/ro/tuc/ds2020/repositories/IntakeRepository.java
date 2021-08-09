package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Intake;

import java.util.List;
import java.util.Optional;


@Repository
public interface IntakeRepository extends JpaRepository<Intake, Integer> {

    public List<Intake> findByPatient_Id(Integer patientID);

}
