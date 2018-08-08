package services.Interfaces;

import entities.ProductByRecipe;
import entities.Recipe;
import entities.UserInfo;
import lombok.NonNull;

import java.util.Collection;
import java.util.Map;

public interface RecipeService {

    Long createRecipe(@NonNull Long idUserInfo);

    Recipe provideRecipe(@NonNull Long idRecipe);

    void deleteRecipe(@NonNull Long idRecipe);

    Collection<ProductByRecipe> provideProductsByRecipe(@NonNull Long idRecipe);

    Map<Long, UserInfo> provideFinalUsersFromRecipe(@NonNull Long idRecipe);
}
