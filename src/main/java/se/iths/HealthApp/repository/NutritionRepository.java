package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.iths.HealthApp.entity.NutritionEntity;

@Repository
public interface NutritionRepository extends CrudRepository<NutritionEntity, Long> {
}
