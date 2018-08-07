package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.Food;
import ftc.shift.sample.entities.ProductByFridge;
import lombok.NonNull;

import java.util.List;

public interface FoodService {

    Food provideFood(@NonNull Long idFood);

    void deleteFood(@NonNull Long idFood);

    Long createFood();

    List<Food> provideListFoodStartWith(@NonNull String startNameOfFood);

    List<ProductByFridge> provideListProductByFridge(@NonNull Long idFood);
}