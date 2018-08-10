package services.Interfaces;

import entities.data.RecipeData;
import entities.data.UserInfoData;
import entities.enums.StateByProduct;

import java.util.List;
import java.util.Map;

public interface UserInfoService {

    UserInfoData createUserInfo(UserInfoData userInfoData);

    Boolean deleteUserInfo(Long idUserInfo);

    UserInfoData provideUserInfo(Long idUserInfo);

    UserInfoData updateUserInfo(Long idUserInfo, UserInfoData newUserInfoData);

    List<RecipeData> provideAllRecipesByUserInfo(Long idUserInfo);

    Map<Long, StateByProduct> provideStatesByProduct(Long idUserInfo);



    Boolean changeStateByProduct(Long idUserInfo, Long idProductByRecipe, StateByProduct newState);
}