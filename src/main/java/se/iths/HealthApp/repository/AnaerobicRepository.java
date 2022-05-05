package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.HealthApp.entity.AnaerobicEntity;

@Repository
public interface AnaerobicRepository extends CrudRepository<AnaerobicEntity, Long> {
}
