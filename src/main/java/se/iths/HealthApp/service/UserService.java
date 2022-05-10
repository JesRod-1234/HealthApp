package se.iths.HealthApp.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.HealthApp.Exception.NoSuchIDException;
import se.iths.HealthApp.entity.RoleEntity;
import se.iths.HealthApp.entity.UserEntity;
import se.iths.HealthApp.repository.RoleRepository;
import se.iths.HealthApp.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
       this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByName("ROLE_USER");
        user.addRole(roleToAdd);
        return userRepository.save(user);
    }

    public Optional<UserEntity> findUserById(Long id) {
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!")));
    }

    public void deleteUser(Long id) {
        UserEntity foundItem = userRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!"));
        userRepository.deleteById(foundItem.getId());
    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }
}
