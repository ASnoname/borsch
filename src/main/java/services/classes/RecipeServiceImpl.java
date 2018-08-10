package services.classes;

import entities.Recipe;
import entities.UserInfo;
import entities.data.ProductByRecipeData;
import entities.data.RecipeData;
import repositories.RecipeRepository;
import repositories.UserInfoRepository;
import services.Interfaces.ProductByRecipeService;
import services.Interfaces.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserInfoRepository userInfoRepository;
    private final ProductByRecipeService productByRecipeService;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, UserInfoRepository userInfoRepository, ProductByRecipeService productByRecipeService) {
        this.recipeRepository = recipeRepository;
        this.userInfoRepository = userInfoRepository;
        this.productByRecipeService = productByRecipeService;
    }

    @Override
    public RecipeData createRecipe(RecipeData recipeData, Long idUserInfo) {

        if (recipeData == null){
            return null;
        }

        Recipe recipe = new Recipe();
        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (userInfo.isPresent()){

            recipe
                    .setUserInfo(userInfo.get());

            userInfo
                    .get()
                    .getRecipes()
                    .add(recipe);

            recipe
                    .setRecipeData(recipeData);

            recipe = recipeRepository.save(recipe);

            recipe
                    .getRecipeData()
                    .setId(recipe
                            .getId());

            recipeRepository.save(recipe);

            return recipe.getRecipeData();
        }
        else {
            return  null;
        }
    }

    @Override
    public RecipeData provideRecipe(Long idRecipe) {

        try {
            Optional<Recipe> recipe = recipeRepository.findById(idRecipe);

            return recipe
                    .map(Recipe::getRecipeData)
                    .orElse(null);
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public Boolean deleteRecipe(Long idRecipe) {

        try {
            Optional<Recipe> recipe = recipeRepository.findById(idRecipe);

            if (recipe.isPresent()){

                if (!deleteAllProductByRecipe(idRecipe)){
                    return false;
                }

                recipe
                        .get()
                        .getUserInfo()
                        .getRecipes()
                        .remove(recipe
                                .get());

                recipeRepository.deleteById(idRecipe);

                return true;
            }
            else {
                return null;
            }
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public RecipeData updateRecipe(RecipeData newRecipeData, Long idRecipe) {

        try {
            Optional<Recipe> recipe = recipeRepository.findById(idRecipe);

            if (recipe.isPresent() && newRecipeData != null){

                newRecipeData.setId(recipe.get().getId());

                recipe.get().setRecipeData(newRecipeData);

                recipeRepository.save(recipe.get());

                return recipe.get().getRecipeData();
            }
            else {
                return null;
            }
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public List<ProductByRecipeData> provideAllProductByRecipe(Long idRecipe) {

        try {
            Optional<Recipe> recipe = recipeRepository.findById(idRecipe);

            if (recipe.isPresent()){

                List<ProductByRecipeData> result = new ArrayList<>();

                recipe
                        .get()
                        .getProducts()
                        .parallelStream()
                        .forEach(p -> result
                                .add(p.getProductByRecipeData()));

                return result;
            }
            else {
                return null;
            }
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public Boolean deleteAllProductByRecipe(Long idRecipe) {

        try {
            Optional<Recipe> recipe = recipeRepository.findById(idRecipe);

            if (recipe.isPresent()){

                recipe
                        .get()
                        .getProducts()
                        .parallelStream()
                        .forEach(p -> productByRecipeService
                                .deleteProductByRecipe(p.getId()));

                return true;
            }
            else {
                return false;
            }
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }

    @Override
    public Map<Long, UserInfo> provideMapFinalUsers(Long idRecipe) {

        try {
            Optional<Recipe> recipe = recipeRepository.findById(idRecipe);

            Map<Long, UserInfo> result = new HashMap<>();

            if (recipe.isPresent()){

                recipe
                        .get()
                        .getProducts()
                        .parallelStream()
                        .forEach(p -> result
                                .put(p.getId(),p.getUserInfo()));

                return result;
            }
            else {
                return null;
            }
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }
}