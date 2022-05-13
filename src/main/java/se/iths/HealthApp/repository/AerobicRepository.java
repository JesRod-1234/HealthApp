package se.iths.HealthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.HealthApp.entity.AerobicEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AerobicRepository extends CrudRepository<AerobicEntity, Long> {

    List<AerobicEntity> findAllByCreatedAtBetween(LocalDate start, LocalDate end);


}
