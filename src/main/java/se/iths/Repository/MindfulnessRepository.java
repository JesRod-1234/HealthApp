package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.Entity.MindfulnessEntity;

public interface MindfulnessRepository extends CrudRepository<MindfulnessEntity, Long> {
}
