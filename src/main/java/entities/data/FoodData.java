package entities.data;

import entities.enums.TypeFood;
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
public class FoodData implements Serializable {

    @Column(name = "id",unique = true)
    private Long id;

    @Column(name = "name",unique = true,nullable = false)
    private String name;

    @Column(name = "category",nullable = false)
    private TypeFood category;
}
