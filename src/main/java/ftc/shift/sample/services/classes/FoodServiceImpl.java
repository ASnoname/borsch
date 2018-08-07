package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.Food;
import ftc.shift.sample.entities.ProductByFridge;
import ftc.shift.sample.repositories.FoodRepository;
import ftc.shift.sample.services.Interfaces.FoodService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(final FoodRepository foodRepository) {

        this.foodRepository = foodRepository;
    }

    @Override
    public Food provideFood(@NonNull Long idFood) {

        return foodRepository
                .findById(idFood)
                .get();
    }

    @Override
    public void deleteFood(@NonNull Long idFood) {

        foodRepository.deleteById(idFood);
    }

    @Override
    public Long createFood() {

        Food food = new Food();

        foodRepository.save(food);

        return food.getId();
    }

    @Override
    public List<Food> provideListFoodStartWith(@NonNull String startNameOfFood) {

        List<Food> fitFoods = new ArrayList<>();

        StreamSupport.stream(foodRepository.findAll().spliterator(), false)
                .filter(food -> (food.getName().length() >= startNameOfFood.length()))
                .filter(food -> food.getName().startsWith(startNameOfFood))
                .forEach(fitFoods::add);

        return fitFoods;
    }

    @Override
    public List<ProductByFridge> provideListProductByFridge(@NonNull Long idFood) {

        return foodRepository
                .findById(idFood)
                .get()
                .getProducts();
    }
}