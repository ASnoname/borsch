package controllers;

import entities.data.FoodData;
import services.Interfaces.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  FoodController {

    private static final String FOOD_PATH = Resources.FOOD_PREFIX;
    private static final String ADMIN_FOOD_PATH = Resources.ADMIN_FOOD_PREFIX;

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping(FOOD_PATH + "{start}")
    public @ResponseBody
    BaseResponse<List<FoodData>> provideListFood(@PathVariable(name = "start") String start) {

        return new BaseResponse<>(foodService.provideListFoodStartWith(start));
    }

    @GetMapping(ADMIN_FOOD_PATH + "{id}")
    public @ResponseBody
    BaseResponse<FoodData> provideFood(@PathVariable(name = "id") Long id) {

        return new BaseResponse<>(foodService.provideFood(id));
    }

    @DeleteMapping(ADMIN_FOOD_PATH + "{id}")
    public @ResponseBody
    BaseResponse deleteFood(@PathVariable(name = "id") Long id) {

        return new BaseResponse<>(foodService.deleteFood(id));
    }

    @PostMapping(ADMIN_FOOD_PATH + "new")
    public @ResponseBody
    BaseResponse<FoodData> createFood(@RequestBody FoodData foodData) {

        return new BaseResponse<>(foodService.createFood(foodData));
    }

    @PatchMapping(ADMIN_FOOD_PATH + "{id}")
    public @ResponseBody
    BaseResponse<FoodData> updateFood(@PathVariable(name = "id") Long id, @RequestBody FoodData foodData) {

        return new BaseResponse<>(foodService.updateFood(id, foodData));
    }
}