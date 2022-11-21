package se.iths.HealthApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import se.iths.HealthApp.entity.ResistanceTrainingEntity;
import se.iths.HealthApp.service.ResistanceTrainingService;

import java.util.Optional;

@RestController
@RequestMapping("resistancetraining")
@CrossOrigin
public class ResistanceTrainingController {

    private final ResistanceTrainingService resistanceTrainingService;

    public ResistanceTrainingController(ResistanceTrainingService resistanceTrainingService) {
        this.resistanceTrainingService = resistanceTrainingService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ResistanceTrainingEntity>> findAllResistanceTrainingEntries() {
        Iterable<ResistanceTrainingEntity> allResistanceTrainingEntries = resistanceTrainingService.findAllResistanceTrainingEntries();
        return new ResponseEntity<>(allResistanceTrainingEntries, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ResistanceTrainingEntity>> findResistanceTrainingEntryById(@PathVariable Long id) {
        Optional<ResistanceTrainingEntity> foundResistanceTrainingEntry = resistanceTrainingService.findResistanceTrainingEntryById(id);
        return new ResponseEntity<>(foundResistanceTrainingEntry, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResistanceTrainingEntity> createResistanceTrainingEntry(@RequestBody ResistanceTrainingEntity anaerobic) {
        ResistanceTrainingEntity createdResistanceTrainingEntry = resistanceTrainingService.createResistanceTrainingEntry(anaerobic);
        return new ResponseEntity<>(createdResistanceTrainingEntry, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteResistanceTrainingEntry(@PathVariable Long id) {
        resistanceTrainingService.deleteResistanceTrainingEntry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
