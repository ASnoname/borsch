package services.Interfaces;

import entities.data.RecipeData;
import entities.data.UserInfoData;
import entities.enums.StateByProduct;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserInfoService {

    Optional<UserInfoData> createUserInfo(UserInfoData userInfoData);

    Boolean deleteUserInfo(Long idUserInfoData);

    Optional<UserInfoData> provideUserInfo(Long idUserInfoData);

    Optional<UserInfoData> updateUserInfo(Long idUserInfoData, UserInfoData newUserInfoData);

    Optional<List<RecipeData>> provideAllRecipesByUserInfo(Long idUserInfoData);

    Optional<Map<Long, StateByProduct>> provideStatesForProductByRecipe(Long idUserInfoData);
}