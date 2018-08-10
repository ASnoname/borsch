package services.classes;

import entities.*;
import entities.data.ProductByRecipeData;
import entities.data.UserInfoData;
import entities.enums.StateByProduct;
import repositories.FoodRepository;
import repositories.ProductByRecipeRepository;
import repositories.RecipeRepository;
import repositories.UserInfoRepository;
import services.Interfaces.ProductByRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ProductByRecipeServiceImpl implements ProductByRecipeService {

    private final ProductByRecipeRepository productByRecipeRepository;
    private final UserInfoRepository userInfoRepository;
    private final RecipeRepository recipeRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public ProductByRecipeServiceImpl(final ProductByRecipeRepository productByRecipeRepository, UserInfoRepository userInfoRepository, RecipeRepository recipeRepository, FoodRepository foodRepository) {

        this.productByRecipeRepository = productByRecipeRepository;
        this.userInfoRepository = userInfoRepository;
        this.recipeRepository = recipeRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public ProductByRecipeData addProductByRecipe(Long idRecipe, ProductByRecipeData productByRecipeData) {

        Optional<Recipe> recipe;

        try {
            recipe = recipeRepository.findById(idRecipe);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (recipe.isPresent() && productByRecipeData != null){

            ProductByRecipe productByRecipe = new ProductByRecipe();

            Optional<Food> food = getCorrectFood(productByRecipeData);

            if (!food.isPresent()){
                return null;
            }

            productByRecipe.setFood(food.get());
            productByRecipe.setRecipe(recipe.get());
            productByRecipe.setProductByRecipeData(productByRecipeData);

            productByRecipe = productByRecipeRepository.save(productByRecipe);
            productByRecipeData.setId(productByRecipe.getId());
            productByRecipe = productByRecipeRepository.save(productByRecipe);

            sendInvite(productByRecipeData, food.get(), productByRecipe);

            return productByRecipe.getProductByRecipeData();
        }
        else {
            return null;
        }
    }

    private void sendInvite(ProductByRecipeData productByRecipeData, Food food, ProductByRecipe finalProductByRecipe) {

        food
                .getProducts()
                .parallelStream()
                .filter(p -> p
                        .getProductByFridgeData()
                        .getFreeAmount() >= productByRecipeData
                        .getAmount())
                .forEach(p -> p
                        .getFridge()
                        .getUserInfo()
                        .getStateByProductMap()
                        .put(finalProductByRecipe
                                .getId(), StateByProduct.WAITING));
    }

    private Optional<Food> getCorrectFood(ProductByRecipeData productByRecipeData) {
        return StreamSupport
                        .stream(foodRepository
                                .findAll()
                                .spliterator(), true)
                        .filter(f -> f
                                .getFoodData()
                                .getName()
                                .equals(productByRecipeData
                                        .getName()))
                        .findFirst();
    }

    @Override
    public Boolean deleteProductByRecipe(Long idProductByRecipe) {

        try {
            Optional<ProductByRecipe> productByRecipe = productByRecipeRepository.findById(idProductByRecipe);

            if (productByRecipe.isPresent()){

                productByRecipe
                        .get()
                        .getRecipe()
                        .getProducts()
                        .remove(productByRecipe
                                .get());

                UserInfo userInfo = productByRecipe.get().getUserInfo();

                if (userInfo != null && userInfo
                                            .getStateByProductMap()
                                            .get(idProductByRecipe)
                                            .equals(StateByProduct.ACCEPTED)){

                    resetProductByFridge(productByRecipe.get());
                }

                removeFromStatesMap(idProductByRecipe);

                productByRecipeRepository.deleteById(idProductByRecipe);

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

    private void removeFromStatesMap(Long idProductByRecipe) {

        StreamSupport
                .stream(userInfoRepository
                        .findAll()
                        .spliterator(), true)
                .filter(u -> u
                        .getStateByProductMap()
                        .containsKey(idProductByRecipe))
                .forEach(u -> u.getStateByProductMap().remove(idProductByRecipe));
    }

    private void resetProductByFridge(ProductByRecipe productByRecipe) {
        Optional<ProductByFridge> productByFridge = productByRecipe
                .getUserInfo()
                .getFridge()
                .getProducts()
                .parallelStream()
                .filter(p -> p
                        .getProductByFridgeData()
                        .getName()
                        .equals(productByRecipe
                                .getProductByRecipeData()
                                .getName()))
                .findFirst();

        if (productByFridge.isPresent()){

            Double reservedAmount = productByRecipe.getProductByRecipeData().getAmount();

            Double allAmount = productByFridge.get().getProductByFridgeData().getAllAmount();
            Double freeAmount = productByFridge.get().getProductByFridgeData().getFreeAmount();

            productByFridge.get().getProductByFridgeData().setFreeAmount(freeAmount + allAmount - reservedAmount);
        }
    }

    @Override
    public ProductByRecipeData provideProductByRecipe(Long idProductByRecipe) {

        try {
            Optional<ProductByRecipe> productByRecipe = productByRecipeRepository.findById(idProductByRecipe);

            return productByRecipe
                    .map(ProductByRecipe::getProductByRecipeData)
                    .orElse(null);
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public List<UserInfoData> provideOffers(Long idProductByRecipe) {

        List<UserInfoData> userInfoDataList = new ArrayList<>();

        Optional<ProductByRecipe> productByRecipe;

        try {
            productByRecipe = productByRecipeRepository.findById(idProductByRecipe);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (productByRecipe.isPresent()){

            productByRecipe
                    .get()
                    .getOffers()
                    .parallelStream()
                    .forEach(userInfo -> userInfoDataList.add(userInfo.getUserInfoData()));

            return userInfoDataList;
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean deleteUserInfoFromOffers(Long idProductByRecipe, Long idUserInfo) {

        Optional<ProductByRecipe> productByRecipe;
        Optional<UserInfo> userInfo;

        try {
            productByRecipe = productByRecipeRepository.findById(idProductByRecipe);
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return false;
        }

        if (productByRecipe.isPresent() && userInfo.isPresent()){

            userInfo
                    .get()
                    .getStateByProductMap()
                    .put(idProductByRecipe,StateByProduct.DENIED);

            productByRecipe
                    .get()
                    .getOffers()
                    .remove(userInfo
                            .get());

            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public ProductByRecipeData updateProductByRecipe(Long idProductByRecipe, ProductByRecipeData newProductByRecipeData) {


    }

    @Override
    public Boolean clearFinalUserInfo(Long idProductByRecipe) {
        return null;
    }

    @Override
    public UserInfoData changeFinalUserInfo(Long idProductByRecipe, Long newIdUserInfo) {
        return null;
    }
}
