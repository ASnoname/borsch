package ftc.shift.sample.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Food")
public class Food{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "productsFromFridgesByFood")
    @Column(name = "products")
    private List<ProductByFridge> products;

    @Column(name = "name",unique = true,length = 20)
    private String name;

    @Column(name = "category")
    private TypeFood category;
}
