package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.HealthApp.entity.MindfulnessEntity;

@Repository
public interface MindfulnessRepository extends CrudRepository<MindfulnessEntity, Long> {
}
