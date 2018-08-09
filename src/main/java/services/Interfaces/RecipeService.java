package services.Interfaces;

import entities.ProductByRecipe;
import entities.Recipe;
import entities.UserInfo;

import java.util.Collection;
import java.util.Map;

public interface RecipeService {

    Long createRecipe(Long idUserInfo);

    Recipe provideRecipe(Long idRecipe);

    void deleteRecipe(Long idRecipe);

    Collection<ProductByRecipe> provideProductsByRecipe(Long idRecipe);

    Map<Long, UserInfo> provideFinalUsersFromRecipe(Long idRecipe);
}
