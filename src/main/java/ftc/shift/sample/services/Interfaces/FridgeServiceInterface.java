package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.models.Food;
import ftc.shift.sample.models.Fridge;
import ftc.shift.sample.models.Product;
import ftc.shift.sample.models.UserValidInfo;

import java.util.List;

public interface FridgeServiceInterface {
    Fridge provideUserFridge(String id);

    Fridge addProductInFridge(String id, Product product);

    //3. List<Food> getFoodSearchList(String foodName);


}