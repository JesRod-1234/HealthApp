package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.entity.AerobicEntity;
import se.iths.HealthApp.repository.AerobicRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class AerobicService {

    @PersistenceContext
    EntityManager entityManager;

    private final AerobicRepository aerobicRepository;

    public AerobicService(AerobicRepository anaerobicRepository) {
        this.aerobicRepository = anaerobicRepository;
    }

    public AerobicEntity createAerobicItem(AerobicEntity anaerobic) {
        return aerobicRepository.save(anaerobic);
    }

    public Optional<AerobicEntity> findAerobicItemById(Long id) {
        return Optional.ofNullable(aerobicRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteAerobicItem(Long id) {
        AerobicEntity foundItem = aerobicRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        aerobicRepository.deleteById(foundItem.getId());
    }

    public Iterable<AerobicEntity> findAllAerobicItems() {
        return aerobicRepository.findAll();
    }


    //public List<AerobicEntity> numberOfExercises(double startDate, double endDate){
      //  String query = "SELECT i FROM Item i WHERE i. BETWEEN :minPrice AND :maxPrice";



    //}



}
