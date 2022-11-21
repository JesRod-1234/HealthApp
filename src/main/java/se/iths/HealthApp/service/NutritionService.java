package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;

import se.iths.HealthApp.Exception.NoSuchIDException;
import se.iths.HealthApp.entity.NutritionEntity;
import se.iths.HealthApp.repository.NutritionRepository;

import java.util.Optional;

@Service
public class NutritionService {

    private final NutritionRepository nutritionRepository;

    public NutritionService(NutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    public NutritionEntity createMeal(NutritionEntity diet) {
        return nutritionRepository.save(diet);
    }

    public Optional<NutritionEntity> findMealById(Long id) {
        return Optional.ofNullable(nutritionRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!")));
    }

    public void deleteMeal(Long id) {
        NutritionEntity foundDietItem = nutritionRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!"));
        nutritionRepository.deleteById(foundDietItem.getId());
    }

    public Iterable<NutritionEntity> findAllMeals() {
        return nutritionRepository.findAll();
    }
}
