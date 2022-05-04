package se.iths.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long phoneNumber;

    @ManyToMany
    private List<AerobicEntity> aerobicEntity;

    @ManyToMany
    private List<AnaerobicEntity> anaerobicEntity;

    @OneToMany
    private List<DietEntity> dietEntity;

    @OneToMany
    private List<EquipmentEntity> equipmentEntity;

    @OneToMany
    private List<MindfulnessEntity> mindfulnessEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<AerobicEntity> getAerobicEntity() {
        return aerobicEntity;
    }

    public void setAerobicEntity(List<AerobicEntity> aerobicEntity) {
        this.aerobicEntity = aerobicEntity;
    }

    public List<AnaerobicEntity> getAnaerobicEntity() {
        return anaerobicEntity;
    }

    public void setAnaerobicEntity(List<AnaerobicEntity> anaerobicEntity) {
        this.anaerobicEntity = anaerobicEntity;
    }

    public List<DietEntity> getDietEntity() {
        return dietEntity;
    }

    public void setDietEntity(List<DietEntity> dietEntity) {
        this.dietEntity = dietEntity;
    }

    public List<EquipmentEntity> getEquipmentEntity() {
        return equipmentEntity;
    }

    public void setEquipmentEntity(List<EquipmentEntity> equipmentEntity) {
        this.equipmentEntity = equipmentEntity;
    }

    public List<MindfulnessEntity> getMindfulnessEntity() {
        return mindfulnessEntity;
    }

    public void setMindfulnessEntity(List<MindfulnessEntity> mindfulnessEntity) {
        this.mindfulnessEntity = mindfulnessEntity;
    }

    public UserEntity() {
    }
}
