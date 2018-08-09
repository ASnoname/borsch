package services.classes;

import entities.UserInfo;
import entities.data.RecipeData;
import entities.data.UserInfoData;
import entities.enums.StateByProduct;
import repositories.UserInfoRepository;
import services.Interfaces.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImpl(final UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public Optional<UserInfoData> createUserInfo(UserInfoData userInfoData) {

        if (userInfoData == null){
            return Optional.empty();
        }
        else {
            UserInfo userInfo = new UserInfo();

            userInfo.setUserInfoData(userInfoData);

            userInfo = userInfoRepository.save(userInfo);

            userInfo
                    .getUserInfoData()
                    .setId(userInfo
                            .getId());

            userInfoRepository.save(userInfo);

            return Optional.of(userInfo.getUserInfoData());
        }
    }

    @Override
    public Boolean deleteUserInfo(Long idUserInfoData) {

        try {
            if (userInfoRepository.findById(idUserInfoData).isPresent()) {
                userInfoRepository.deleteById(idUserInfoData);
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

    @Override
    public Optional<UserInfoData> provideUserInfo(Long idUserInfoData) {

        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfoData);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        return userInfo.map(UserInfo::getUserInfoData);
    }

    @Override
    public Optional<UserInfoData> updateUserInfo(Long idUserInfoData, UserInfoData newUserInfoData) {

        Optional<UserInfo> oldUserInfo;

        try {
            oldUserInfo = userInfoRepository.findById(idUserInfoData);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        if (oldUserInfo.isPresent()){

            Long id = oldUserInfo
                    .get()
                    .getUserInfoData()
                    .getId();

            newUserInfoData
                    .setId(id);

            oldUserInfo
                    .get()
                    .setUserInfoData(newUserInfoData);

            userInfoRepository.save(oldUserInfo.get());

            return Optional.of(oldUserInfo.get().getUserInfoData());
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<RecipeData>> provideAllRecipesByUserInfo(Long idUserInfoData) {

        List<RecipeData> recipeDataList = new ArrayList<>();

        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfoData);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        if (userInfo.isPresent()){

            userInfo
                    .get()
                    .getRecipes()
                    .parallelStream()
                    .forEach(recipe -> recipeDataList.add(recipe.getRecipeData()));

            return Optional.of(recipeDataList);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Map<Long, StateByProduct>> provideStatesForProductByRecipe(Long idUserInfoData) {

        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfoData);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        return userInfo.map(UserInfo::getStateByProductMap);
    }
}