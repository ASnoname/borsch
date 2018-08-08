package services.Interfaces;

import entities.data.FoodData;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    Optional<FoodData> provideFood(Long idFoodData);

    Boolean deleteFood(Long idFoodData);

    Optional<FoodData> createFood(FoodData foodData);

    Optional<List<FoodData>> provideListFoodStartWith(String startNameOfFood);

    Optional<FoodData> updateFood(Long idFoodData, FoodData newFoodData);
}