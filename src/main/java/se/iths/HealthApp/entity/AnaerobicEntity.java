package se.iths.HealthApp.entity;

import javax.persistence.*;

@Entity
public class AnaerobicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long numberOfRepetitions;

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
}
