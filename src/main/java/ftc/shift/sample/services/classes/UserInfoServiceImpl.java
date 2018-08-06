package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.Recipe;
import ftc.shift.sample.entities.UserInfo;
import ftc.shift.sample.entities.enums.StateByProduct;
import ftc.shift.sample.repositories.UserInfoRepository;
import ftc.shift.sample.services.Interfaces.UserInfoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImpl(final UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public Collection<Recipe> getAllRecipesByUserInfo(Long idUserInfo) {
        return null;
    }

    @Override
    public void createRecipeByUserInfo(Long idUserInfo, Recipe recipe) {

    }

    @Override
    public UserInfo provideUserInfo(Long idUserInfo) {
        return null;
    }

    @Override
    public void deleteUserInfo(Long idUserInfo) {

    }

    @Override
    public void updateFirstName(Long IdUserInfo, String newFirstName) {

    }

    @Override
    public void updateSecondName(Long IdUserInfo, String newSecondName) {

    }

    @Override
    public void updateCity(Long IdUserInfo, String newCity) {

    }

    @Override
    public void updateUniversity(Long IdUserInfo, String newUniversity) {

    }

    @Override
    public void updateDormitory(Long IdUserInfo, String newDormitory) {

    }

    @Override
    public void updateRoom(Long IdUserInfo, String newRoom) {

    }

    @Override
    public void updateLinkToVk(Long IdUserInfo, String newLinkToVk) {

    }

    @Override
    public void updateLinkToTelegram(Long IdUserInfo, String newLinkToTelegram) {

    }

    @Override
    public void updateCookRate(Long IdUserInfo, Double newCookRate) {

    }

    @Override
    public void updateEatRate(Long IdUserInfo, Double newEatRate) {

    }

    @Override
    public Map<Long, StateByProduct> getStatesForProductByRecipe(Long idUserInfo) {
        return null;
    }

    @Override
    public void deleteStateForProductByRecipe(Long idUserInfo, Long idProductByRecipe) {

    }

    @Override
    public void updateStateForProductByRecipe(Long idUserInfo, Long idProductByRecipe, StateByProduct newState) {

    }

    @Override
    public void createStateForProductByRecipe(Long idUserInfo, Long idProductByRecipe, StateByProduct state) {

    }

    @Override
    public StateByProduct getStateForProductByRecipe(Long idUserInfo, Long idProductByRecipe) {
        return null;
    }
}