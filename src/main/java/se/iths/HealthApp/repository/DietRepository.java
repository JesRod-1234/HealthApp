package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.HealthApp.entity.DietEntity;

@Repository
public interface DietRepository extends CrudRepository<DietEntity, Long> {
}
