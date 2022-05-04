package se.iths.excercise.Service;

import org.springframework.stereotype.Service;
import se.iths.excercise.Entity.MindfulnessEntity;
import se.iths.excercise.repository.MindfulnessRepository;

import javax.persistence.EntityNotFoundException;
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
        return Optional.ofNullable(mindfulnessRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteMindfulness(Long id) {
        MindfulnessEntity foundMindfulness = mindfulnessRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        mindfulnessRepository.deleteById(foundMindfulness.getId());
    }

    public Iterable<MindfulnessEntity> findAllMindfulness() {
        return mindfulnessRepository.findAll();
    }

}
