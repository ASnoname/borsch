package entities;

import entities.data.FoodData;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Food")
public class Food implements Serializable {

    {
        this.products = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private long id;

    @OneToMany(fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "listProductsByFood")
    @Column(name = "products")
    private List<ProductByFridge> products;

    @OneToOne
    private FoodData foodData;
}