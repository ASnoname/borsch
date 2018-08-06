package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.ProductByRecipe;
import ftc.shift.sample.entities.Recipe;
import ftc.shift.sample.entities.UserInfo;
import lombok.NonNull;

import java.util.Collection;
import java.util.List;

public interface RecipeService {

    Recipe getRecipe(@NonNull Long idRecipe);

    void updateName(@NonNull Long idRecipe, @NonNull String newName);

    void deleteRecipe(@NonNull Long idRecipe);

    Collection<ProductByRecipe> getProductsByRecipe(@NonNull Long idRecipe);

    void createProductByRecipe(@NonNull Long idRecipe, @NonNull ProductByRecipe productByRecipe);

    List<UserInfo> getFinalUsersFromRecipe(@NonNull Long idRecipe);
}
