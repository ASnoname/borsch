package ftc.shift.sample.entities;

import ftc.shift.sample.entities.enums.TypeFood;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Food")
public class Food{

    {
        this.products = new ArrayList<>();
        this.category = TypeFood.Element;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private long id;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "productsFromFridgesByFood")
    @Column(name = "products")
    private Collection<ProductByFridge> products;

    @Column(name = "name",unique = true,length = 20)
    private String name;

    @Column(name = "category")
    private TypeFood category;
}
