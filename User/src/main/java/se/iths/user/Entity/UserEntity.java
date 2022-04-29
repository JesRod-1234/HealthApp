package se.iths.user.Entity;

import se.iths.excercise.Entity.AerobicEntity;

import javax.persistence.*;

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
    private AerobicEntity aerobicEntity;






}
