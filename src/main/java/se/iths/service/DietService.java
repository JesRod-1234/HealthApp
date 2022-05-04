package se.iths.service;

import org.springframework.stereotype.Service;
import se.iths.Entity.DietEntity;
import se.iths.repository.DietRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class DietService {

    private final DietRepository dietRepository;

    public DietService(DietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }
    public DietEntity createDietItem(DietEntity diet) {

        return dietRepository.save(diet);
    }

    public Optional<DietEntity> findDietItemById(Long id) {
        return Optional.ofNullable(dietRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteDietItem(Long id) {
        DietEntity foundDietItem = dietRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        dietRepository.deleteById(foundDietItem.getId());
    }

    public Iterable<DietEntity> findAllIDietItems() {
        return dietRepository.findAll();
    }
}
