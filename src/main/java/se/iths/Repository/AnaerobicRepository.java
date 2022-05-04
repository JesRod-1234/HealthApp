package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.Entity.AnaerobicEntity;

@Repository
public interface AnaerobicRepository extends CrudRepository<AnaerobicEntity, Long> {
}
