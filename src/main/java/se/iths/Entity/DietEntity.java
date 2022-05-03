package se.iths.Entity;

import javax.persistence.*;

@Entity
public class DietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameOfDish;
    private Long numberOfCalories;
    private String mealTimes;

    @ManyToOne
    private UserEntity userEntities;

    public DietEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfDish() {
        return nameOfDish;
    }

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }

    public Long getNumberOfCalories() {
        return numberOfCalories;
    }

    public void setNumberOfCalories(Long numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
    }

    public String getMealTimes() {
        return mealTimes;
    }

    public void setMealTimes(String mealTimes) {
        this.mealTimes = mealTimes;
    }

    public UserEntity getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(UserEntity userEntities) {
        this.userEntities = userEntities;
    }
}
