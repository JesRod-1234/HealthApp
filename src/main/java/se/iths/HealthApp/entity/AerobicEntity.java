package se.iths.HealthApp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class AerobicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long duration;

    @ManyToMany (mappedBy = "aerobics")
    private List<UserEntity> users;

    public AerobicEntity() {
    }

    public void addUser(UserEntity user) {
        users.add(user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

}
