package se.iths.service;

import org.springframework.stereotype.Service;
import se.iths.Entity.AnaerobicEntity;
import se.iths.repository.AnaerobicRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AnaerobicService {

    private  final  AnaerobicRepository anaerobicRepository;

    public AnaerobicService(AnaerobicRepository anaerobicRepository) {
        this.anaerobicRepository = anaerobicRepository;
    }

    public AnaerobicEntity createAnaerobicItem(AnaerobicEntity anaerobic) {

        return anaerobicRepository.save(anaerobic);
    }

    public Optional<AnaerobicEntity> findAnaerobicItemById(Long id) {
        return Optional.ofNullable(anaerobicRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteAnaerobicItem(Long id) {
        AnaerobicEntity foundItem = anaerobicRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        anaerobicRepository.deleteById(foundItem.getId());
    }

    public Iterable<AnaerobicEntity> findAllAnaerobicItems() {
        return anaerobicRepository.findAll();
    }
}
