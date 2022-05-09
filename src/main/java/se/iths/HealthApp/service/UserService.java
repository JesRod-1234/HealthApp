package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.entity.*;
import se.iths.HealthApp.repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AerobicRepository aerobicRepository;
    private final AnaerobicRepository anaerobicRepository;
    private final DietRepository dietRepository;
    private final EquipmentRepository equipmentRepository;
    private final MindfulnessRepository mindfulnessRepository;

    public UserService(UserRepository userRepository, AerobicRepository aerobicRepository, AnaerobicRepository anaerobicRepository, DietRepository dietRepository, EquipmentRepository equipmentRepository, MindfulnessRepository mindfulnessRepository) {
        this.userRepository = userRepository;
        this.aerobicRepository = aerobicRepository;
        this.anaerobicRepository = anaerobicRepository;
        this.dietRepository = dietRepository;
        this.equipmentRepository = equipmentRepository;
        this.mindfulnessRepository = mindfulnessRepository;
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateAerobicInUser(Long aerobicId, Long userId) {
        AerobicEntity foundAerobic = aerobicRepository.findById(aerobicId).orElse(new AerobicEntity());
        UserEntity userToUpdate = userRepository.findById(userId).orElse(new UserEntity());

        userToUpdate.addAerobic(foundAerobic);
        return userRepository.save(userToUpdate);
    }

    public UserEntity updateAnaerobicInUser(Long anaerobicId, Long userId) {
        AnaerobicEntity foundAnaerobic = anaerobicRepository.findById(anaerobicId).orElse(new AnaerobicEntity());
        UserEntity userToUpdate = userRepository.findById(userId).orElse(new UserEntity());

        userToUpdate.addAnaerobic(foundAnaerobic);
        return userRepository.save(userToUpdate);
    }

    public UserEntity updateDietInUser(Long dietId, Long userId) {
        DietEntity foundDiet = dietRepository.findById(dietId).orElse(new DietEntity());
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


}
