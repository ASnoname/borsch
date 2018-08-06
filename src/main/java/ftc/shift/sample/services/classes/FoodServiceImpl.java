package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.Food;
import ftc.shift.sample.entities.enums.TypeFood;
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

        return foodRepository.findById(idFood).get();
    }

    @Override
    public void updateName(@NonNull Long idFood, @NonNull String newName) {

        foodRepository.findById(idFood).get().setName(newName);
    }

    @Override
    public TypeFood provideCategory(Long idFood) {

        return foodRepository.findById(idFood).get().getCategory();
    }

    @Override
    public void updateCategory(Long idFood, TypeFood newTypeFood) {

        foodRepository.findById(idFood).get().setCategory(newTypeFood);
    }

    @Override
    public void deleteFood(@NonNull Long idFood) {
        foodRepository.deleteById(idFood);
    }

    @Override
    public void createFood(@NonNull Food food) {
        foodRepository.save(food);
    }

    @Override
    public Iterable<Food> provideAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public List<Food> getListFoodStartWith(@NonNull String startNameOfFood) {

        List<Food> fitFoods = new ArrayList<>();

        StreamSupport.stream(foodRepository.findAll().spliterator(), true)
                .filter(food -> (food.getName().length() >= startNameOfFood.length()))
                .filter(food -> food.getName().startsWith(startNameOfFood))
                .forEach(fitFoods::add);
        return fitFoods;
    }
}