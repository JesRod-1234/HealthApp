package se.iths.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.Entity.DietEntity;
import se.iths.Service.DietService;

import java.util.Optional;

@RestController
@RequestMapping("diet")

public class DietController {
    private final DietService dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @PostMapping
    public ResponseEntity<DietEntity> createDietItem(@RequestBody DietEntity diet) {
        DietEntity createdDietItem = dietService.createDietItem(diet);
        return new ResponseEntity<>(createdDietItem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<DietEntity>> findDietItemById(@PathVariable Long id) {
        Optional<DietEntity> foundDietItem = dietService.findDietItemById(id);
        return new ResponseEntity<>(foundDietItem, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDietItem(@PathVariable Long id) {
        dietService.deleteDietItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<DietEntity>> findAllDietItems() {
        Iterable<DietEntity> allDietItems = dietService.findAllIDietItems();
        return new ResponseEntity<>(allDietItems, HttpStatus.OK);
    }
}
