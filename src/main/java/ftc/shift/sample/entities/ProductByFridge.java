package ftc.shift.sample.entities;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "ProductByFridge")
public class ProductByFridge{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fridgeId")
    private Fridge fridge;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    @Column(name = "allAmount")
    private Double allAmount;

    @Column(name = "reservedAmount")
    private Double reservedAmount;
}