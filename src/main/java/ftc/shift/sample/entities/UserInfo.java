package ftc.shift.sample.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
@Entity
@Table(name = "UserInfo")
public class UserInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fridgeId")
    Fridge fridge;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "recipesByUserInfoId")
    @Column(name = "recipe")
    private List<Recipe> recipes;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "stateByProduct")
    @MapKeyColumn(name = "productId")
    @Column(name = "state")
    private Map<Long, StateByProduct> stateByProductMap;

    @Column(name = "firstName",length = 20)
    private String firstName;

    @Column(name = "secondName",length = 20)
    private String secondName;

    @Column(name = "city",length = 20)
    private String city;

    @Column(name = "unversity",length = 40)
    private String university;

    @Column(name = "dormitory",length = 10)
    private String dormitory;

    @Column(name = "room",length = 10)
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