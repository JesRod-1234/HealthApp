package se.iths.HealthApp.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long phoneNumber;
    private Long healthCheck;


    @ManyToMany
    private Set<AerobicEntity> aerobics;

    @ManyToMany
    private List<AnaerobicEntity> anaerobics;

    @OneToMany
    private List<DietEntity> diets;

    @OneToMany
    private List<EquipmentEntity> equipments;

    @OneToMany
    private List<MindfulnessEntity> mindfulnessEntities;

    public UserEntity() {
    }

    public void addAerobic(AerobicEntity aerobic) {
        aerobics.add(aerobic);
        aerobic.addUser(this);
    }

    public void addAnaerobic(AnaerobicEntity anaerobic) {
        anaerobics.add(anaerobic);
        anaerobic.addUser(this);
    }

    public void addDiet(DietEntity diet) {
        diets.add(diet);
    }

    public void addEquipment(EquipmentEntity equipment) {
        equipments.add(equipment);
    }

    public void addMindfulness(MindfulnessEntity item) {
        mindfulnessEntities.add(item);
    }

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

    public Set<AerobicEntity> getAerobics() {
        return aerobics;
    }

    public void setAerobics(Set<AerobicEntity> aerobics) {
        this.aerobics = aerobics;
    }

    public List<AnaerobicEntity> getAnaerobics() {
        return anaerobics;
    }

    public void setAnaerobics(List<AnaerobicEntity> anaerobics) {
        this.anaerobics = anaerobics;
    }

    public List<DietEntity> getDiets() {
        return diets;
    }

    public void setDiets(List<DietEntity> diets) {
        this.diets = diets;
    }

    public List<EquipmentEntity> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<EquipmentEntity> equipments) {
        this.equipments = equipments;
    }

    public List<MindfulnessEntity> getMindfulnessEntities() {
        return mindfulnessEntities;
    }

    public void setMindfulnessEntities(List<MindfulnessEntity> mindfulnessEntities) {
        this.mindfulnessEntities = mindfulnessEntities;
    }
}
