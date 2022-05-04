package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.Entity.EquipmentEntity;

@Repository
public interface EquipmentRepository extends CrudRepository<EquipmentEntity, Long> {
}
