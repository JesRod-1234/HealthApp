package se.iths.HealthApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import se.iths.HealthApp.entity.NutritionEntity;
import se.iths.HealthApp.service.NutritionService;

import java.util.Optional;

@RestController
@RequestMapping("meals")
@CrossOrigin
public class NutritionController {

    private final NutritionService nutritionService;

    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<NutritionEntity>> findAllMeals() {
        Iterable<NutritionEntity> allDietItems = nutritionService.findAllMeals();
        return new ResponseEntity<>(allDietItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NutritionEntity> createMeal(@RequestBody NutritionEntity diet) {
        NutritionEntity createdDietItem = nutritionService.createMeal(diet);
        return new ResponseEntity<>(createdDietItem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<NutritionEntity>> findMealById(@PathVariable Long id) {
        Optional<NutritionEntity> foundDietItem = nutritionService.findMealById(id);
        return new ResponseEntity<>(foundDietItem, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long id) {
        nutritionService.deleteMeal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
