package se.iths.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.Entity.DietEntity;

@Repository
public interface DietRepository extends CrudRepository<DietEntity,Long> {
}
