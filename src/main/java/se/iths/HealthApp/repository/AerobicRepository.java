package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.HealthApp.entity.AerobicEntity;
import java.util.Date;
import java.util.List;

@Repository
public interface AerobicRepository extends CrudRepository<AerobicEntity, Long> {

    List<AerobicEntity> findAllByDateCreatedBetweenAndId(Date start, Date end, Long userId);
}
