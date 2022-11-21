package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;

import se.iths.HealthApp.Exception.NoSuchIDException;
import se.iths.HealthApp.entity.ResistanceTrainingEntity;
import se.iths.HealthApp.repository.ResistanceTrainingRepository;

import java.util.Optional;

@Service
public class ResistanceTrainingService {

    private final ResistanceTrainingRepository resistanceTrainingRepository;

    public ResistanceTrainingService(ResistanceTrainingRepository resistanceTrainingRepository) {
        this.resistanceTrainingRepository = resistanceTrainingRepository;
    }

    public ResistanceTrainingEntity createResistanceTrainingEntry(ResistanceTrainingEntity resistanceTrainingEntity) {
        return resistanceTrainingRepository.save(resistanceTrainingEntity);
    }

    public Optional<ResistanceTrainingEntity> findResistanceTrainingEntryById(Long id) {
        return Optional.ofNullable(resistanceTrainingRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!")));
    }

    public void deleteResistanceTrainingEntry(Long id) {
        ResistanceTrainingEntity foundItem = resistanceTrainingRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!"));
        resistanceTrainingRepository.deleteById(foundItem.getId());
    }

    public Iterable<ResistanceTrainingEntity> findAllResistanceTrainingEntries() {
        return resistanceTrainingRepository.findAll();
    }
}
