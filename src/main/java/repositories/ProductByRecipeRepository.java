package repositories;

import entities.ProductByRecipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductByRecipeRepository extends CrudRepository<ProductByRecipe,Long> {
}
