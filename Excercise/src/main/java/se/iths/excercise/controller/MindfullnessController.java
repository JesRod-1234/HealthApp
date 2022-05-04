package se.iths.excercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.excercise.Entity.EquipmentEntity;
import se.iths.excercise.Entity.MindfulnessEntity;
import se.iths.excercise.Service.MindfulnessService;

import java.util.Optional;

@RestController
@RequestMapping("mindfulness")
public class MindfullnessController {

    private final MindfulnessService mindfulnessService;

    public MindfullnessController(MindfulnessService mindfulnessService) {
        this.mindfulnessService = mindfulnessService;
    }

    @PostMapping
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
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204. Allt gick bra men du får inte tillbaka något.
    }

    @GetMapping
    public ResponseEntity<Iterable<MindfulnessEntity>> findAllItems() {
        Iterable<MindfulnessEntity> allMindfulness = mindfulnessService.findAllMindfulness();
        return new ResponseEntity<>(allMindfulness, HttpStatus.OK);
    }


}
