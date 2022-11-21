package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.iths.HealthApp.entity.ResistanceTrainingEntity;

@Repository
public interface ResistanceTrainingRepository extends CrudRepository<ResistanceTrainingEntity, Long> {
}
