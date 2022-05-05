package se.iths.HealthApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.HealthApp.entity.MindfulnessEntity;
import se.iths.HealthApp.service.MindfulnessService;

import java.util.Optional;

@RestController
@RequestMapping("mindfulness")
public class MindfulnessController {

    private final MindfulnessService mindfulnessService;

    public MindfulnessController(MindfulnessService mindfulnessService) {
        this.mindfulnessService = mindfulnessService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<MindfulnessEntity>> findAllItems() {
        Iterable<MindfulnessEntity> allMindfulness = mindfulnessService.findAllMindfulness();
        return new ResponseEntity<>(allMindfulness, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<MindfulnessEntity> createMindfulness(@RequestBody MindfulnessEntity mindfulness) {
        MindfulnessEntity createdMindfulness = mindfulnessService.createMindfulness(mindfulness);
        return new ResponseEntity<>(createdMindfulness, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<MindfulnessEntity>> findMindfulnessById(@PathVariable Long id) {
        Optional<MindfulnessEntity> foundMindfulness = mindfulnessService.findMindfulnessById(id);
        return new ResponseEntity<>(foundMindfulness, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMindfulness(@PathVariable Long id) {
        mindfulnessService.deleteMindfulness(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
