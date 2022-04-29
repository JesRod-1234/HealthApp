package se.iths.excercise.Entity;

import se.iths.user.Entity.UserEntity;

import javax.persistence.*;

@Entity
public class AerobicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long duration;

    @ManyToMany(mappedBy = "userEntity")
    private UserEntity userEntity;



}
