package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.Exception.NoSuchIDException;
import se.iths.HealthApp.entity.DietEntity;
import se.iths.HealthApp.repository.DietRepository;

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
        return Optional.ofNullable(dietRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!")));
    }

    public void deleteDietItem(Long id) {
        DietEntity foundDietItem = dietRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!"));
        dietRepository.deleteById(foundDietItem.getId());
    }

    public Iterable<DietEntity> findAllIDietItems() {
        return dietRepository.findAll();
    }
}
