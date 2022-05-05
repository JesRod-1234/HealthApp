package se.iths.HealthApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.HealthApp.entity.EquipmentEntity;
import se.iths.HealthApp.service.EquipmentService;

import java.util.Optional;

@RestController
@RequestMapping("equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<EquipmentEntity>> findAllItems() {
        Iterable<EquipmentEntity> allEquipments = equipmentService.findAllEquipments();
        return new ResponseEntity<>(allEquipments, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<EquipmentEntity> createItem(@RequestBody EquipmentEntity equipment) {
        EquipmentEntity createdEquipment = equipmentService.createEquipment(equipment);
        return new ResponseEntity<>(createdEquipment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<EquipmentEntity>> findEquipmentById(@PathVariable Long id) {
        Optional<EquipmentEntity> foundEquipment = equipmentService.findEquipmentById(id);
        return new ResponseEntity<>(foundEquipment, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204. Allt gick bra men du får inte tillbaka något.
    }
}
