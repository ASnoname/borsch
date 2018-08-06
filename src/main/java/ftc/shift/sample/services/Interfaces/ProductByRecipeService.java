package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.ProductByRecipe;
import ftc.shift.sample.entities.UserInfo;
import lombok.NonNull;

import java.util.Collection;

public interface ProductByRecipeService {

    void updateProductByRecipe(@NonNull ProductByRecipe productByRecipe);

    void deleteProductByRecipe(@NonNull Long idProductByRecipe);

    ProductByRecipe getProductByRecipe(@NonNull Long idProductByRecipe);

    UserInfo getFinalUserInfo(@NonNull Long idProductByRecipe);

    void updateFinalUserInfo(@NonNull Long idProductByRecipe, @NonNull Long idUserInfo);

    void clearFinalUserInfo(@NonNull Long idProductByRecipe);

    Collection<UserInfo> getOffers(@NonNull Long idProductByRecipe);

    void addOffer(@NonNull Long idProductByRecipe, @NonNull Long idUserInfo);

    void clearOffers(@NonNull Long idProductByRecipe);

    void deleteOffer(@NonNull Long idProductByRecipe, @NonNull Long idUserInfo);
}
