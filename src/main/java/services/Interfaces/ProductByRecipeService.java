package services.Interfaces;

import entities.ProductByRecipe;
import entities.UserInfo;
import lombok.NonNull;

import java.util.List;

public interface ProductByRecipeService {

    Long createIdProductByRecipe(@NonNull Long idRecipe, @NonNull Long idFood);

    Long provideIdProductByRecipe(@NonNull ProductByRecipe productByRecipe);

    ProductByRecipe provideProductByRecipe(@NonNull Long idProductByRecipe);

    void deleteProductByRecipe(@NonNull Long idProductByRecipe);

    List<UserInfo> provideOffers(@NonNull Long idProductByRecipe);

    void addUserInfoToOffers(@NonNull Long idProductByRecipe, @NonNull Long idUserInfo);

    void deleteUserInfoFromOffers(@NonNull Long idProductByRecipe, @NonNull Long idUserInfo);

    void clearOffers(@NonNull Long idProductByRecipe);

    Long provideIdUserInfo(@NonNull Long idProductByRecipe);

    void clearFinalUserInfo(@NonNull Long idProductByRecipe);

    void changeFinalUserInfo(@NonNull Long idProductByRecipe, @NonNull Long newIdUserInfo);
}