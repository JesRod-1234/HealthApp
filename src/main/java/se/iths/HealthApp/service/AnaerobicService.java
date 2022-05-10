package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.Exception.NoSuchIDException;
import se.iths.HealthApp.entity.AnaerobicEntity;
import se.iths.HealthApp.repository.AnaerobicRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AnaerobicService {

    private final AnaerobicRepository anaerobicRepository;

    public AnaerobicService(AnaerobicRepository anaerobicRepository) {
        this.anaerobicRepository = anaerobicRepository;
    }

    public AnaerobicEntity createAnaerobicItem(AnaerobicEntity anaerobic) {
        return anaerobicRepository.save(anaerobic);
    }

    public Optional<AnaerobicEntity> findAnaerobicItemById(Long id) {
        return Optional.ofNullable(anaerobicRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!")));
    }

    public void deleteAnaerobicItem(Long id) {
        AnaerobicEntity foundItem = anaerobicRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!"));
        anaerobicRepository.deleteById(foundItem.getId());
    }

    public Iterable<AnaerobicEntity> findAllAnaerobicItems() {
        return anaerobicRepository.findAll();
    }
}
