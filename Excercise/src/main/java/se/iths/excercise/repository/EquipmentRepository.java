package se.iths.excercise.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.excercise.Entity.EquipmentEntity;

@Repository
public interface EquipmentRepository extends CrudRepository<EquipmentEntity, Long> {
}
