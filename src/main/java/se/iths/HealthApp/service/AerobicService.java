package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.Exception.NoSuchIDException;
import se.iths.HealthApp.entity.AerobicEntity;
import se.iths.HealthApp.repository.AerobicRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
        return Optional.ofNullable(aerobicRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!")));
    }

    public void deleteAerobicItem(Long id) {
        AerobicEntity foundItem = aerobicRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!"));
        aerobicRepository.deleteById(foundItem.getId());
    }

    public Iterable<AerobicEntity> findAllAerobicItems() {
        return aerobicRepository.findAll();
    }
}
