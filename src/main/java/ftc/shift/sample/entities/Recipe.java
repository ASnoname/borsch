package ftc.shift.sample.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Recipe")
public class Recipe{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name",length = 30)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "userInfoId")
    private UserInfo userInfo;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "productsInRecipe")
    @Column(name = "product")
    private List<ProductByRecipe> products;
}