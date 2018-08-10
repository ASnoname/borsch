package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Fridge")
public class Fridge implements Serializable {

    {
        this.products = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private long id;

    @OneToOne
    @JoinColumn(name = "userInfoId")
    UserInfo userInfo;

    @OneToMany(fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "productsInFridge")
    @Column(name = "products")
    private List<ProductByFridge> products;
}
