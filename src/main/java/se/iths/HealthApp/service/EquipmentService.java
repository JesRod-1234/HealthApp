package se.iths.HealthApp.service;

import org.springframework.stereotype.Service;
import se.iths.HealthApp.Exception.NoSuchIDException;
import se.iths.HealthApp.entity.EquipmentEntity;
import se.iths.HealthApp.repository.EquipmentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public EquipmentEntity createEquipment(EquipmentEntity equipment) {
        return equipmentRepository.save(equipment);
    }

    public Optional<EquipmentEntity> findEquipmentById(Long id) {
        return Optional.ofNullable(equipmentRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!")));
    }

    public void deleteEquipment(Long id) {
        EquipmentEntity foundEquipment = equipmentRepository.findById(id).orElseThrow(() -> new NoSuchIDException("No such Id!"));
        equipmentRepository.deleteById(foundEquipment.getId());
    }

    public Iterable<EquipmentEntity> findAllEquipments() {
        return equipmentRepository.findAll();
    }
}
