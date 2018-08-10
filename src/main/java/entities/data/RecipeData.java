package entities.data;

import entities.enums.StateRecipe;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
@Table(name = "FoodData")
public class RecipeData implements Serializable {

    {
        this.state = StateRecipe.ACTIVE;
    }

    @Column(name = "id",unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "state",nullable = false)
    private StateRecipe state;
}
