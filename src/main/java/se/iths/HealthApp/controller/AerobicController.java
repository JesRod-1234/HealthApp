package se.iths.HealthApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.HealthApp.Exception.EmailAlreadyExist;
import se.iths.HealthApp.entity.AerobicEntity;
import se.iths.HealthApp.entity.UserEntity;
import se.iths.HealthApp.service.AerobicService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aerobics")
public class AerobicController {

    private final AerobicService aerobicService;

    public AerobicController(AerobicService aerobicService) {
        this.aerobicService = aerobicService;
    }

    @GetMapping
    public ResponseEntity<Iterable<AerobicEntity>> findAllAerobicItems() {
        Iterable<AerobicEntity> allAerobicItems = aerobicService.findAllAerobicItems();
        return new ResponseEntity<>(allAerobicItems, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<AerobicEntity>> findAerobicItemById(@PathVariable Long id) {

        Optional<AerobicEntity> foundAerobicItem = aerobicService.findAerobicItemById(id);
        return new ResponseEntity<>(foundAerobicItem, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AerobicEntity> createAerobicItem(@RequestBody AerobicEntity aerobic) {

        List<AerobicEntity> allAerobic;
        allAerobic = (List<AerobicEntity>) aerobicService.findAllAerobicItems();

        for (AerobicEntity aerobic1 : allAerobic) {
            if (aerobic1.getName().equals(aerobic.getName())) {
                throw new EmailAlreadyExist("Name already exist!");
            }
        }
        AerobicEntity createdAerobic = aerobicService.createAerobicItem(aerobic);
        return new ResponseEntity<>(createdAerobic, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAerobicItem(@PathVariable Long id) {

        aerobicService.deleteAerobicItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
