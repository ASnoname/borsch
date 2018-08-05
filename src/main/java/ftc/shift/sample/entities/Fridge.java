package ftc.shift.sample.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Fridge")
public class Fridge{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToOne(mappedBy = "fridge")
    @JoinColumn(name = "userInfoId")
    private UserInfo userInfo;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "productsInFridge")
    @Column(name = "products")
    private List<ProductByFridge> products;
}
