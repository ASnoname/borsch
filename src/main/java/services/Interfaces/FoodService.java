package services.Interfaces;

import entities.data.FoodData;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    FoodData provideFood(Long idFood);

    Boolean deleteFood(Long idFood);

    FoodData createFood(FoodData foodData);

    List<FoodData> provideListFoodStartWith(String startNameOfFood);

    FoodData updateFood(Long idFood, FoodData newFoodData);
}