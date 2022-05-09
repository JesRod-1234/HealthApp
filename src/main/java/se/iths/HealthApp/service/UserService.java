package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.entity.AerobicEntity;
import se.iths.HealthApp.entity.UserEntity;
import se.iths.HealthApp.repository.AerobicRepository;
import se.iths.HealthApp.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AerobicRepository aerobicRepository;

    public UserService(UserRepository userRepository, AerobicRepository aerobicRepository) {
        this.userRepository = userRepository;
        this.aerobicRepository = aerobicRepository;
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(Long aerobicId, Long userId) {
        AerobicEntity foundAerobic = aerobicRepository.findById(aerobicId).orElse(new AerobicEntity());
        UserEntity userToUpdate = userRepository.findById(userId).orElse(new UserEntity());

        userToUpdate.addAerobic(foundAerobic);

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
