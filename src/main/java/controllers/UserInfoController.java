package controllers;

import entities.data.RecipeData;
import entities.data.UserInfoData;
import entities.enums.StateByProduct;
import services.Interfaces.UserInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserInfoController {

    private static final String USERS_PATH = Resources.USER_PREFIX;

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping(USERS_PATH)
    public @ResponseBody
    BaseResponse<UserInfoData> createUserInfo(@RequestBody UserInfoData userInfoData) {

        BaseResponse<UserInfoData> response = new BaseResponse<>();

        Optional<UserInfoData> resultUserInfoData = userInfoService.createUserInfo(userInfoData);

        if (resultUserInfoData.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(resultUserInfoData.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Не удалось создать пользователя!");
        }

        return response;
    }

    @DeleteMapping(USERS_PATH + "{idUserInfoData}")
    public @ResponseBody
    BaseResponse deleteUserInfo(@PathVariable Long idUserInfoData) {

        BaseResponse response = new BaseResponse();

        if (userInfoService.deleteUserInfo(idUserInfoData)) {
            response.setStatus(Resources.SUCCESS_STATUS);
        }
        else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Пользователь с таким id не удален!");
        }

        return response;
    }

    @GetMapping(USERS_PATH + "{idUserInfoData}")
    public @ResponseBody
    BaseResponse<UserInfoData> provideUserInfo(@PathVariable Long idUserInfoData) {

        BaseResponse<UserInfoData> response = new BaseResponse<>();

        Optional<UserInfoData> userInfoData = userInfoService.provideUserInfo(idUserInfoData);

        if (userInfoData.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(userInfoData.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Пользователь с таким id не найден!");
        }

        return response;
    }

    @PatchMapping(USERS_PATH + "{idUserInfoData}")
    public @ResponseBody
    BaseResponse<UserInfoData> updateUserInfo(@PathVariable Long idUserInfoData, @RequestBody UserInfoData userInfoData) {

        BaseResponse<UserInfoData> response = new BaseResponse<>();

        Optional<UserInfoData> resultUserInfoData = userInfoService.updateUserInfo(idUserInfoData, userInfoData);

        if (resultUserInfoData.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(resultUserInfoData.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Не удалось изменить пользователя!");
        }

        return response;
    }

    @GetMapping(USERS_PATH + "{idUserInfoData}" + "/recipes")
    public @ResponseBody
    BaseResponse<List<RecipeData>> provideListRecipe(@PathVariable Long idUserInfoData) {

        BaseResponse<List<RecipeData>> response = new BaseResponse<>();

        Optional<List<RecipeData>> recipes = userInfoService.provideAllRecipesByUserInfo(idUserInfoData);

        if (recipes.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(recipes.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Пользователь с таким id не найден!");
        }

        return response;
    }

    @GetMapping(USERS_PATH + "{idUserInfoData}" + "/states")
    public @ResponseBody
    BaseResponse<Map<Long, StateByProduct>> provideMapStates(@PathVariable Long idUserInfoData) {

        BaseResponse<Map<Long, StateByProduct>> response = new BaseResponse<>();

        Optional<Map<Long, StateByProduct>> states = userInfoService.provideStatesForProductByRecipe(idUserInfoData);

        if (states.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(states.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Пользователь с таким id не найден!");
        }

        return response;
    }
}