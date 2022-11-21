package se.iths.HealthApp.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.HealthApp.entity.RoleEntity;
import se.iths.HealthApp.entity.UserEntity;
import se.iths.HealthApp.repository.RoleRepository;
import se.iths.HealthApp.repository.UserRepository;
import se.iths.HealthApp.entity.*;
import se.iths.HealthApp.repository.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private final AerobicRepository aerobicRepository;
    private final ResistanceTrainingRepository resistanceTrainingRepository;
    private final NutritionRepository nutritionRepository;
    private final EquipmentRepository equipmentRepository;
    private final MindfulnessRepository mindfulnessRepository;

    public UserService(UserRepository userRepository, AerobicRepository aerobicRepository, ResistanceTrainingRepository resistanceTrainingRepository, NutritionRepository nutritionRepository, EquipmentRepository equipmentRepository, MindfulnessRepository mindfulnessRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.aerobicRepository = aerobicRepository;
        this.resistanceTrainingRepository = resistanceTrainingRepository;
        this.nutritionRepository = nutritionRepository;
        this.equipmentRepository = equipmentRepository;
        this.mindfulnessRepository = mindfulnessRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByName("ROLE_USER");
        user.addRole(roleToAdd);
        return userRepository.save(user);
    }

    public UserEntity updateAerobicInUser(Long aerobicId, Long userId) {
        AerobicEntity foundAerobic = aerobicRepository.findById(aerobicId).orElse(new AerobicEntity());
        UserEntity userToUpdate = userRepository.findById(userId).orElse(new UserEntity());

        userToUpdate.addAerobic(foundAerobic);
        return userRepository.save(userToUpdate);
    }

    public UserEntity updateAnaerobicInUser(Long anaerobicId, Long userId) {
        ResistanceTrainingEntity foundAnaerobic = resistanceTrainingRepository.findById(anaerobicId).orElse(new ResistanceTrainingEntity());
        UserEntity userToUpdate = userRepository.findById(userId).orElse(new UserEntity());

        userToUpdate.addResistanceTrainings(foundAnaerobic);
        return userRepository.save(userToUpdate);
    }

    public UserEntity updateDietInUser(Long dietId, Long userId) {
        NutritionEntity foundDiet = nutritionRepository.findById(dietId).orElse(new NutritionEntity());
        UserEntity userToUpdate = userRepository.findById(userId).orElse(new UserEntity());

        userToUpdate.addDiet(foundDiet);
        return userRepository.save(userToUpdate);
    }

    public UserEntity updateEquipmentInUser(Long equipmentId, Long userId) {
        EquipmentEntity foundEquipment = equipmentRepository.findById(equipmentId).orElse(new EquipmentEntity());
        UserEntity userToUpdate = userRepository.findById(userId).orElse(new UserEntity());

        userToUpdate.addEquipment(foundEquipment);
        return userRepository.save(userToUpdate);
    }

    public UserEntity updateMindfulnessInUser(Long mindfulnessId, Long userId) {
        MindfulnessEntity found = mindfulnessRepository.findById(mindfulnessId).orElse(new MindfulnessEntity());
        UserEntity userToUpdate = userRepository.findById(userId).orElse(new UserEntity());

        userToUpdate.addMindfulness(found);
        return userRepository.save(userToUpdate);
    }

    public Optional<UserEntity> findUserById(Long id) {
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteUser(Long id) {
        UserEntity foundItem = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        userRepository.deleteById(foundItem.getId());
    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public String checkHealth(Long id) {

        UserEntity foundUser = userRepository.findById(id).orElse(new UserEntity());

        LocalDate today = LocalDate.now();
        LocalDate sevenDaysBefore = LocalDate.now().minusDays(7);

        List<AerobicEntity> last7DaysExercises = aerobicRepository.findAllByCreatedAtBetween(sevenDaysBefore, today);
        List<AerobicEntity> exercisesOfOneUser = new ArrayList<>();

        for (AerobicEntity exercise : last7DaysExercises) {
            if (exercise.getUsers().contains(foundUser)) {
                exercisesOfOneUser.add(exercise);
            }
        }

        if (exercisesOfOneUser.size() < 5) {
            return "You are not exercising, enough, you'll be fat    " + last7DaysExercises.size();
        } else {
            return "bra jobbat!";
        }
    }
}
