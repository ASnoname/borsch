package services.Interfaces;

import entities.UserInfo;
import entities.data.ProductByRecipeData;
import entities.data.RecipeData;

import java.util.List;
import java.util.Map;

public interface RecipeService {

    RecipeData createRecipe(RecipeData recipeData, Long idUserInfo);

    RecipeData provideRecipe(Long idRecipe);

    Boolean deleteRecipe(Long idRecipe);

    RecipeData updateRecipe(RecipeData newRecipeData, Long idRecipe);

    List<ProductByRecipeData> provideAllProductByRecipe(Long idRecipe);

    Boolean deleteAllProductByRecipe(Long idRecipe);

    Map<Long, UserInfo> provideMapFinalUsers(Long idRecipe);
}