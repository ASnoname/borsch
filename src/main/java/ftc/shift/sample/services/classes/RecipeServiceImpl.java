package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.ProductByRecipe;
import ftc.shift.sample.entities.Recipe;
import ftc.shift.sample.entities.UserInfo;
import ftc.shift.sample.repositories.RecipeRepository;
import ftc.shift.sample.services.Interfaces.RecipeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe getRecipe(@NonNull Long idRecipe) {
        return recipeRepository.findById(idRecipe).get();
    }

    @Override
    public void updateName(@NonNull Long idRecipe, @NonNull String newName) {
        recipeRepository.findById(idRecipe).get().setName(newName);
    }

    @Override
    public void deleteRecipe(@NonNull Long idRecipe) {
        recipeRepository.deleteById(idRecipe);
    }

    @Override
    public Collection<ProductByRecipe> getProductsByRecipe(@NonNull Long idRecipe) {
        return recipeRepository.findById(idRecipe).get().getProducts();
    }

    @Override
    public void createProductByRecipe(@NonNull Long idRecipe, @NonNull ProductByRecipe productByRecipe) {
        recipeRepository.findById(idRecipe).get().getProducts().add(productByRecipe);

        productByRecipe.setRecipe(recipeRepository.findById(idRecipe).get());
    }

    @Override
    public List<UserInfo> getFinalUsersFromRecipe(@NonNull Long idRecipe) {

        List<UserInfo> userInfoList = new ArrayList<>();

        recipeRepository
                .findById(idRecipe)
                .get()
                .getProducts()
                .forEach(productByRecipe -> userInfoList.add(productByRecipe.getUserInfo()));

        return userInfoList;
    }
}
