//package ftc.shift.sample.controllers;
//
//import ftc.shift.sample.entities.Food;
//import ftc.shift.sample.services.Interfaces.FoodServiceInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.Collection;
//
//@RestController
//public class  FoodController {
//
//    private static final String FOOD_PATH = Resources.API_PREFIX + "food";
//
//    private final FoodServiceInterface foodService;
//
//    @Autowired
//    public FoodController(FoodServiceInterface foodService) {
//        this.foodService = foodService;
//    }
//
//    @GetMapping(FOOD_PATH+"/{nameFood}")
//    public @ResponseBody
//    BaseResponse<Collection<Food>> provideFoodSearchList(@PathVariable String nameFood) {
//        BaseResponse<Collection<Food>> response = new BaseResponse<>();
//        Collection<Food> food = foodService.getListFoodStartWith(nameFood);
//        response.setData(food);
//        return response;
//    }
//}
