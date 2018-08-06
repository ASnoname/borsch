package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.Food;
import ftc.shift.sample.entities.enums.TypeFood;
import lombok.NonNull;

import java.util.List;

public interface FoodService {

    Food provideFood(@NonNull Long idFood);

    void updateName(@NonNull Long idFood, @NonNull String newName);

    TypeFood provideCategory(@NonNull Long idFood);

    void updateCategory(@NonNull Long idFood, @NonNull TypeFood newTypeFood);

    void deleteFood(@NonNull Long idFood);

    void createFood(@NonNull Food food);

    Iterable<Food> provideAllFoods();

    List<Food> getListFoodStartWith(@NonNull String startNameOfFood);
}