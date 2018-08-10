package controllers;

import entities.data.RecipeData;
import entities.data.UserInfoData;
import entities.enums.StateByProduct;
import services.Interfaces.UserInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserInfoController {

    private static final String USERS_PATH = Resources.USER_PREFIX;

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {

        this.userInfoService = userInfoService;
    }

    @GetMapping(USERS_PATH + "new")
    public @ResponseBody
    BaseResponse<UserInfoData> createUserInfo(@RequestBody UserInfoData userInfoData) {

        return new BaseResponse<>(userInfoService.createUserInfo(userInfoData));
    }

    @DeleteMapping(USERS_PATH + "{id}")
    public @ResponseBody
    BaseResponse deleteUserInfo(@PathVariable(name = "id") Long id) {

        return new BaseResponse(userInfoService.deleteUserInfo(id));
    }

    @GetMapping(USERS_PATH + "{id}")
    public @ResponseBody
    BaseResponse<UserInfoData> provideUserInfo(@PathVariable(name = "id") Long id) {

        return new BaseResponse<>(userInfoService.provideUserInfo(id));
    }

    @PatchMapping(USERS_PATH + "{id}")
    public @ResponseBody
    BaseResponse<UserInfoData> updateUserInfo(@PathVariable(name = "id") Long id, @RequestBody UserInfoData userInfoData) {

        return new BaseResponse<>(userInfoService.updateUserInfo(id, userInfoData));
    }

    @GetMapping(USERS_PATH + "{id}" + "/recipes")
    public @ResponseBody
    BaseResponse<List<RecipeData>> provideListRecipe(@PathVariable(name = "id") Long id) {

        return new BaseResponse<>(userInfoService.provideAllRecipesByUserInfo(id));
    }

    @GetMapping(USERS_PATH + "{id}" + "/states")
    public @ResponseBody
    BaseResponse<Map<Long, StateByProduct>> provideMapStates(@PathVariable(name = "id") Long id) {

        return new BaseResponse<>(userInfoService.provideStatesByProduct(id));
    }
}