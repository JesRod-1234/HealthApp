package se.iths.HealthApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.HealthApp.entity.AnaerobicEntity;
import se.iths.HealthApp.service.AnaerobicService;

import java.util.Optional;

@RestController
@RequestMapping("anaerobics")
public class AnaerobicController {

    private final AnaerobicService anaerobicService;

    public AnaerobicController(AnaerobicService anaerobicService) {
        this.anaerobicService = anaerobicService;
    }

    @GetMapping
    public ResponseEntity<Iterable<AnaerobicEntity>> findAllAnaerobicItems() {
        Iterable<AnaerobicEntity> allAnaerobicItems = anaerobicService.findAllAnaerobicItems();
        return new ResponseEntity<>(allAnaerobicItems, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<AnaerobicEntity>> findAnaerobicItemById(@PathVariable Long id) {
        Optional<AnaerobicEntity> foundAnaerobicItem = anaerobicService.findAnaerobicItemById(id);
        return new ResponseEntity<>(foundAnaerobicItem, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AnaerobicEntity> createAnaerobicItem(@RequestBody AnaerobicEntity anaerobic) {
        AnaerobicEntity createdAnaerobic = anaerobicService.createAnaerobicItem(anaerobic);
        return new ResponseEntity<>(createdAnaerobic, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAnaerobicItem(@PathVariable Long id) {
        anaerobicService.deleteAnaerobicItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
