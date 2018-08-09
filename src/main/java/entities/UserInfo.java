package entities;

import entities.data.UserInfoData;
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

    @OneToOne
    private UserInfoData userInfoData;
}
