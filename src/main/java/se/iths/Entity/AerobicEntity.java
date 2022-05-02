package se.iths.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class AerobicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long duration;

    @ManyToMany(mappedBy = "userEntity")
    private List<UserEntity> userEntity;



}
