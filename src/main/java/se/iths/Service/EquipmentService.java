package se.iths.Service;

import org.springframework.stereotype.Service;
import se.iths.Entity.EquipmentEntity;
import se.iths.Repository.EquipmentRepository;

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
        return Optional.ofNullable(equipmentRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteEquipment(Long id) {
        EquipmentEntity foundEquipment = equipmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        equipmentRepository.deleteById(foundEquipment.getId());
    }

    public Iterable<EquipmentEntity> findAllEquipments() {
        return equipmentRepository.findAll();
    }
}
