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
    public UserInfoData createUserInfo(UserInfoData userInfoData) {

        if (userInfoData != null){

            UserInfo userInfo = new UserInfo();

            userInfo.setUserInfoData(userInfoData);

            userInfo = userInfoRepository.save(userInfo);

            userInfo
                    .getUserInfoData()
                    .setId(userInfo
                            .getId());

            userInfoRepository.save(userInfo);

            return userInfo.getUserInfoData();
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean deleteUserInfo(Long idUserInfo) {

        try {
            if (userInfoRepository.findById(idUserInfo).isPresent()) {
                userInfoRepository.deleteById(idUserInfo);
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
    public UserInfoData provideUserInfo(Long idUserInfo) {

        try {
            Optional<UserInfo> userInfo = userInfoRepository.findById(idUserInfo);

            return userInfo
                    .map(UserInfo::getUserInfoData)
                    .orElse(null);
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public UserInfoData updateUserInfo(Long idUserInfo, UserInfoData newUserInfoData) {

        Optional<UserInfo> oldUserInfo;

        try {
            oldUserInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (oldUserInfo.isPresent() && newUserInfoData != null){

            newUserInfoData
                    .setId(oldUserInfo
                            .get()
                            .getUserInfoData()
                            .getId());

            oldUserInfo
                    .get()
                    .setUserInfoData(newUserInfoData);

            userInfoRepository.save(oldUserInfo.get());

            return oldUserInfo.get().getUserInfoData();
        }
        else {
            return null;
        }
    }

    @Override
    public List<RecipeData> provideAllRecipesByUserInfo(Long idUserInfo) {

        List<RecipeData> recipeDataList = new ArrayList<>();

        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (userInfo.isPresent()){

            userInfo
                    .get()
                    .getRecipes()
                    .parallelStream()
                    .forEach(recipe -> recipeDataList.add(recipe.getRecipeData()));

            return recipeDataList;
        }
        else {
            return null;
        }
    }

    @Override
    public Map<Long, StateByProduct> provideStatesByProduct(Long idUserInfo) {

        try {
            Optional<UserInfo> userInfo = userInfoRepository.findById(idUserInfo);

            return userInfo
                    .map(UserInfo::getStateByProductMap)
                    .orElse(null);
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public Boolean changeStateByProduct(Long idUserInfo, Long idProductByRecipe, StateByProduct newState) {

        // изменить состояние у юзера в стейтах
        // добавить этого юзера в офферы по этому продукту если стейт положит, если отриц то удалить из его стейтов

        // ACCEPTED -> DENIED
        // ACCEPTED -> WAITING
        // WAITING -> DENIED



    }
}