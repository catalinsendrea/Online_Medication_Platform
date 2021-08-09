package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Caregiver;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {
}
