package services.Interfaces;

import entities.ProductByRecipe;
import entities.UserInfo;

import java.util.List;

public interface ProductByRecipeService {

    Long createIdProductByRecipe(Long idRecipe, Long idFood);

    ProductByRecipe provideProductByRecipe(Long idProductByRecipe);

    void deleteProductByRecipe(Long idProductByRecipe);

    List<UserInfo> provideOffers(Long idProductByRecipe);

    void addUserInfoToOffers(Long idProductByRecipe, Long idUserInfo);

    void deleteUserInfoFromOffers(Long idProductByRecipe, Long idUserInfo);

    void clearOffers(Long idProductByRecipe);

    Long provideIdUserInfo(Long idProductByRecipe);

    void clearFinalUserInfo(Long idProductByRecipe);

    void changeFinalUserInfo(Long idProductByRecipe, Long newIdUserInfo);
}