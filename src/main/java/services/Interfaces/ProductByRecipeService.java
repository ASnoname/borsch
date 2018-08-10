package services.Interfaces;

import entities.data.ProductByRecipeData;
import entities.data.UserInfoData;
import java.util.List;

public interface ProductByRecipeService {

    ProductByRecipeData addProductByRecipe(Long idRecipe, ProductByRecipeData productByRecipeData);

    Boolean deleteProductByRecipe(Long idProductByRecipe);

    ProductByRecipeData provideProductByRecipe(Long idProductByRecipe);

    ProductByRecipeData updateProductByRecipe(Long idProductByRecipe, ProductByRecipeData newProductByRecipeData);

    List<UserInfoData> provideOffers(Long idProductByRecipe);

    Boolean deleteUserInfoFromOffers(Long idProductByRecipe, Long idUserInfo);

    Boolean clearFinalUserInfo(Long idProductByRecipe);

    UserInfoData changeFinalUserInfo(Long idProductByRecipe, Long newIdUserInfo);
}