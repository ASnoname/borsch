package controllers;

import entities.data.FoodData;
import services.Interfaces.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class  FoodController {

    private static final String FOOD_PATH = Resources.FOOD_PREFIX;
    private static final String ADMIN_FOOD_PATH = Resources.ADMIN_PREFIX + "food/";

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping(FOOD_PATH + "{startNameFood}")
    public @ResponseBody
    BaseResponse<List<FoodData>> provideListFood(@PathVariable String startNameFood) {
        BaseResponse<List<FoodData>> response = new BaseResponse<>();
        Optional<List<FoodData>> foods = foodService.provideListFoodStartWith(startNameFood);

        if (foods.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(foods.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Продуктов с таким названием не найдено!");
        }

        return response;
    }

    @GetMapping(ADMIN_FOOD_PATH + "{idFoodData}")
    public @ResponseBody
    BaseResponse<FoodData> provideFood(@PathVariable Long idFoodData) {

        BaseResponse<FoodData> response = new BaseResponse<>();

        Optional<FoodData> food = foodService.provideFood(idFoodData);

        if (food.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(food.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Продукт с таким id не найден!");
        }

        return response;
    }

    @DeleteMapping(ADMIN_FOOD_PATH + "{idFoodData}")
    public @ResponseBody
    BaseResponse deleteFood(@PathVariable Long idFoodData) {

        BaseResponse response = new BaseResponse();

        if (foodService.deleteFood(idFoodData)) {
            response.setStatus(Resources.SUCCESS_STATUS);
        }
        else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Продукт с таким id не удален!");
        }

        return response;
    }

    @PostMapping(ADMIN_FOOD_PATH)
    public @ResponseBody
    BaseResponse<FoodData> createFood(@RequestBody FoodData foodData) {

        BaseResponse<FoodData> response = new BaseResponse<>();

        Optional<FoodData> resultFood = foodService.createFood(foodData);

        if (resultFood.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(resultFood.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Не удалось создать продукт!");
        }

        return response;
    }

    @PatchMapping(ADMIN_FOOD_PATH + "{idFoodData}")
    public @ResponseBody
    BaseResponse<FoodData> updateFood(@PathVariable Long idFoodData, @RequestBody FoodData foodData) {

        BaseResponse<FoodData> response = new BaseResponse<>();

        Optional<FoodData> resultFood = foodService.updateFood(idFoodData, foodData);

        if (resultFood.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(resultFood.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Не удалось изменить продукт!");
        }

        return response;
    }
}
