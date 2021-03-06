package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.Exception.NoSuchIDException;
import se.iths.HealthApp.entity.MindfulnessEntity;
import se.iths.HealthApp.repository.MindfulnessRepository;

import java.util.Optional;

@Service
public class MindfulnessService {

    private final MindfulnessRepository mindfulnessRepository;

    public MindfulnessService(MindfulnessRepository mindfullnessRepository) {
        this.mindfulnessRepository = mindfullnessRepository;
    }

    public MindfulnessEntity createMindfulness(MindfulnessEntity equipment) {
        return mindfulnessRepository.save(equipment);
    }

    public Optional<MindfulnessEntity> findMindfulnessById(Long id) {
        return Optional.ofNullable(mindfulnessRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!")));
    }

    public void deleteMindfulness(Long id) {
        MindfulnessEntity foundMindfulness = mindfulnessRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!"));
        mindfulnessRepository.deleteById(foundMindfulness.getId());
    }

    public Iterable<MindfulnessEntity> findAllMindfulness() {
        return mindfulnessRepository.findAll();
    }
}
