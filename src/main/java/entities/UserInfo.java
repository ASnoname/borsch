package entities;

import entities.enums.StateByProduct;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Data
@Entity
@Table(name = "UserInfo")
public class UserInfo implements Serializable {

    {
        this.fridge = new Fridge();
        this.recipes = new ArrayList<>();
        this.stateByProductMap = new HashMap<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private long id;

    @OneToOne
    @JoinColumn(name = "fridgeId")
    Fridge fridge;

    @OneToMany(fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "recipesByUserInfoId")
    @Column(name = "recipe")
    private Collection<Recipe> recipes;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "stateByProduct")
    @MapKeyColumn(name = "productId")
    @Column(name = "state")
    private Map<Long, StateByProduct> stateByProductMap;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "city")
    private String city;

    @Column(name = "unversity")
    private String university;

    @Column(name = "dormitory")
    private String dormitory;

    @Column(name = "room")
    private String room;

    @Column(name = "linkToVk")
    private String linkToVk;

    @Column(name = "linkToTelegram")
    private String linkToTelegram;

    @Column(name = "cookRate")
    private Double cookRate;

    @Column(name = "eatRate")
    private Double eatRate;
}
