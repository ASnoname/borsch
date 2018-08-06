package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.Recipe;
import ftc.shift.sample.entities.UserInfo;
import ftc.shift.sample.entities.enums.StateByProduct;
import lombok.NonNull;

import java.util.Collection;
import java.util.Map;

public interface UserInfoService {

    Collection<Recipe> getAllRecipesByUserInfo(@NonNull Long idUserInfo);

    void createRecipeByUserInfo(@NonNull Long idUserInfo, @NonNull Recipe recipe);

    UserInfo provideUserInfo(@NonNull Long idUserInfo);

    void deleteUserInfo(@NonNull Long idUserInfo);

    void updateFirstName(@NonNull Long IdUserInfo, @NonNull String newFirstName);

    void updateSecondName(@NonNull Long IdUserInfo, @NonNull String newSecondName);

    void updateCity(@NonNull Long IdUserInfo, @NonNull String newCity);

    void updateUniversity(@NonNull Long IdUserInfo, @NonNull String newUniversity);

    void updateDormitory(@NonNull Long IdUserInfo, @NonNull String newDormitory);

    void updateRoom(@NonNull Long IdUserInfo, @NonNull String newRoom);

    void updateLinkToVk(@NonNull Long IdUserInfo, @NonNull String newLinkToVk);

    void updateLinkToTelegram(@NonNull Long IdUserInfo, @NonNull String newLinkToTelegram);

    void updateCookRate(@NonNull Long IdUserInfo, @NonNull Double newCookRate);

    void updateEatRate(@NonNull Long IdUserInfo, @NonNull Double newEatRate);

    Map<Long, StateByProduct> getStatesForProductByRecipe(@NonNull Long idUserInfo);

    void deleteStateForProductByRecipe(@NonNull Long idUserInfo, @NonNull Long idProductByRecipe);

    void updateStateForProductByRecipe(@NonNull Long idUserInfo, @NonNull Long idProductByRecipe, @NonNull StateByProduct newState);

    void createStateForProductByRecipe(@NonNull Long idUserInfo, @NonNull Long idProductByRecipe, @NonNull StateByProduct state);

    StateByProduct getStateForProductByRecipe(@NonNull Long idUserInfo, @NonNull Long idProductByRecipe);
}
