package services.Interfaces;

import entities.Recipe;
import entities.UserInfo;
import entities.enums.StateByProduct;
import lombok.NonNull;

import java.util.Collection;
import java.util.Map;

public interface UserInfoService {

    Long createUserInfo();

    void deleteUserInfo(@NonNull Long idUserInfo);

    UserInfo provideUserInfo(@NonNull Long idUserInfo);

    Collection<Recipe> getAllRecipesByUserInfo(@NonNull Long idUserInfo);

    Map<Long, StateByProduct> getStatesForProductByRecipe(@NonNull Long idUserInfo);
}
