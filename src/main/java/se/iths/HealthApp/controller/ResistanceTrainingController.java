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
        Iterable<ResistanceTrainingEntity> allAnaerobicItems = resistanceTrainingService.findAllAnaerobicItems();
        return new ResponseEntity<>(allAnaerobicItems, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ResistanceTrainingEntity>> findResistanceTrainingEntryById(@PathVariable Long id) {
        Optional<ResistanceTrainingEntity> foundAnaerobicItem = resistanceTrainingService.findAnaerobicItemById(id);
        return new ResponseEntity<>(foundAnaerobicItem, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResistanceTrainingEntity> createResistanceTrainingEntry(@RequestBody ResistanceTrainingEntity anaerobic) {
        ResistanceTrainingEntity createdAnaerobic = resistanceTrainingService.createAnaerobicItem(anaerobic);
        return new ResponseEntity<>(createdAnaerobic, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteResistanceTrainingEntry(@PathVariable Long id) {
        resistanceTrainingService.deleteAnaerobicItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
