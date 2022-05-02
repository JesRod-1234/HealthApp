package se.iths.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {

    public UserEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long phoneNumber;

    @ManyToMany
    private List<AerobicEntity> aerobicEntity;

    @ManyToMany
    private List<AnaerobicEntity> anaerobicEntity;

    @OneToMany
    private List<DietEntity> dietEntity;

    @OneToMany
    private List<EquipmentEntity> equipmentEntity;

    @OneToMany
    private List<MindfulnessEntity> mindfulnessEntity;


}
