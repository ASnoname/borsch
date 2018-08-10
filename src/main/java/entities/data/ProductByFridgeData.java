package entities.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
@Table(name = "ProductByFridgeData")
public class ProductByFridgeData implements Serializable {

    @Column(name = "id",unique = true)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "allAmount")
    private Double allAmount;

    @Column(name = "freeAmount")
    private Double freeAmount;
}
