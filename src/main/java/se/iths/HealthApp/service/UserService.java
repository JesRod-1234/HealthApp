package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.entity.UserEntity;
import se.iths.HealthApp.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
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
