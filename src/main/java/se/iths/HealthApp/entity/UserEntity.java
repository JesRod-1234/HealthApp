package se.iths.HealthApp.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
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
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();

    public void addRole(RoleEntity role){
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(RoleEntity role){
        roles.remove(role);
        role.getUsers().remove(this);
    }

    @ManyToMany
    private List<AerobicEntity> aerobics;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<AerobicEntity> getAerobics() {
        return aerobics;
    }

    public void setAerobics(List<AerobicEntity> aerobics) {
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

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
