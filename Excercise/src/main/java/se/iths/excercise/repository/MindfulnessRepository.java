package se.iths.excercise.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.excercise.Entity.MindfulnessEntity;

public interface MindfulnessRepository extends CrudRepository<MindfulnessEntity, Long> {
}
