package entities.data;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class ProductByRecipeData implements Serializable {

    @Column(name = "id",unique = true)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "Amount")
    private Double amount;
}
