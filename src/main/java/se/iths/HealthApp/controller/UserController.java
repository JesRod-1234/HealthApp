package se.iths.HealthApp.controller;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.HealthApp.entity.AerobicEntity;
import se.iths.HealthApp.entity.UserEntity;
import se.iths.HealthApp.service.AerobicService;
import se.iths.HealthApp.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final AerobicService aerobicService;

    public UserController(UserService userService, AerobicService aerobicService) {
        this.userService = userService;
        this.aerobicService = aerobicService;
    }

    @GetMapping
    public ResponseEntity<Iterable<UserEntity>> findAllUsers() {
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<UserEntity>> findUserById(@PathVariable Long id) {
        Optional<UserEntity> foundUser = userService.findUserById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("{userId}/{aerobicId}")
    public ResponseEntity<UserEntity> addAerobicToUser(@PathVariable("userId") Long userId, @PathVariable("aerobicId") Long aerobicId) {

        Optional<UserEntity> foundUserOp = userService.findUserById(userId);
        Optional<AerobicEntity> foundAerobicOp = aerobicService.findAerobicItemById(aerobicId);

        UserEntity userToUpdate = new UserEntity();
        AerobicEntity foundAerobic = new AerobicEntity();

        if (foundUserOp.isPresent()){
            userToUpdate = foundUserOp.get();
        }

        if (foundAerobicOp.isPresent()){
            userToUpdate.addAerobic(foundAerobic);
            foundAerobic.addUser(userToUpdate);
        }

        //userService.createUser(userToUpdate);

        return new ResponseEntity<>(userToUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
