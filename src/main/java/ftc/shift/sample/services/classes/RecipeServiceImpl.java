package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.ProductByRecipe;
import ftc.shift.sample.entities.Recipe;
import ftc.shift.sample.entities.UserInfo;
import ftc.shift.sample.repositories.RecipeRepository;
import ftc.shift.sample.repositories.UserInfoRepository;
import ftc.shift.sample.services.Interfaces.RecipeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, UserInfoRepository userInfoRepository) {
        this.recipeRepository = recipeRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public Long createRecipe(@NonNull Long idUserInfo) {

        Recipe recipe = new Recipe();

        recipe
                .setUserInfo(userInfoRepository
                        .findById(idUserInfo)
                        .get());

        userInfoRepository
                .findById(idUserInfo)
                .get()
                .getRecipes()
                .add(recipe);

        recipeRepository.save(recipe);

        return recipe.getId();
    }

    @Override
    public Recipe provideRecipe(@NonNull Long idRecipe) {

        return recipeRepository
                .findById(idRecipe)
                .get();
    }

    @Override
    public void deleteRecipe(@NonNull Long idRecipe) {

        userInfoRepository
                .findById(recipeRepository
                        .findById(idRecipe)
                        .get()
                        .getUserInfo()
                        .getId())
                .get()
                .getRecipes()
                .remove(recipeRepository
                        .findById(idRecipe)
                        .get());

        recipeRepository.deleteById(idRecipe);
    }

    @Override
    public Collection<ProductByRecipe> provideProductsByRecipe(@NonNull Long idRecipe) {

        return recipeRepository
                .findById(idRecipe)
                .get()
                .getProducts();
    }

    @Override
    public Map<Long, UserInfo> provideFinalUsersFromRecipe(@NonNull Long idRecipe) {

        Map<Long, UserInfo> finalUsersFromRecipe = new HashMap<>();

        recipeRepository
                .findById(idRecipe)
                .get()
                .getProducts()
                .parallelStream()
        .forEach(productByRecipe -> finalUsersFromRecipe
                .put(productByRecipe.getId(),productByRecipe.getUserInfo()));

        return finalUsersFromRecipe;
    }
}
