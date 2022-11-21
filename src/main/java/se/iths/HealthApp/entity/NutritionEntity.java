package se.iths.HealthApp.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class NutritionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mealName;
    private Integer numberOfCalories;
    private LocalDate createdAt;

    @ManyToOne
    private UserEntity user;

    public NutritionEntity() {
    }

    @PrePersist
    public void getCurrentDate() {
        setCreatedAt(LocalDate.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String nameOfDish) {
        this.mealName = nameOfDish;
    }

    public Integer getNumberOfCalories() {
        return numberOfCalories;
    }

    public void setNumberOfCalories(Integer numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
