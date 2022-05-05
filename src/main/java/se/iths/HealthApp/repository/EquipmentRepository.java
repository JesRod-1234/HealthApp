package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.HealthApp.entity.EquipmentEntity;

@Repository
public interface EquipmentRepository extends CrudRepository<EquipmentEntity, Long> {
}
