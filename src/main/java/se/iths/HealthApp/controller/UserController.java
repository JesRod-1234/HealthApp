package se.iths.HealthApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.HealthApp.entity.UserEntity;
import se.iths.HealthApp.service.AerobicService;
import se.iths.HealthApp.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

    @PutMapping("{userId}/aerobic/{aerobicId}")
    public ResponseEntity<UserEntity> addAerobicToUser(@PathVariable("userId") Long userId, @PathVariable("aerobicId") Long aerobicId) {
        UserEntity updatedUser = userService.updateUser(aerobicId, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @PutMapping("{userId}/anaerobic/{anaerobicId}")
    public ResponseEntity<UserEntity> addAnaerobicToUser(@PathVariable("userId") Long userId, @PathVariable("anaerobicId") Long anaerobicId) {
        UserEntity updatedUser = userService.updateUser(anaerobicId, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
