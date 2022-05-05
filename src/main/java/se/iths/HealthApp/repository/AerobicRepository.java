package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.HealthApp.entity.AerobicEntity;

@Repository
public interface AerobicRepository extends CrudRepository<AerobicEntity, Long> {
}
