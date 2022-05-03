package se.iths.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class AnaerobicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long numberOfRepetitions;

    @ManyToMany(mappedBy = "anaerobicEntity")
    private List<UserEntity> userEntities;

    public AnaerobicEntity() {
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

    public Long getNumberOfRepetitions() {
        return numberOfRepetitions;
    }

    public void setNumberOfRepetitions(Long numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
