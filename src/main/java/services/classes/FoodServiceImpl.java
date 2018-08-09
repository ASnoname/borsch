package services.classes;

import entities.Food;
import entities.data.FoodData;
import repositories.FoodRepository;
import services.Interfaces.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(final FoodRepository foodRepository) {

        this.foodRepository = foodRepository;
    }

    @Override
    public Optional<FoodData> provideFood(Long idFoodData){

        Optional<Food> food;

        try {
            food = foodRepository.findById(idFoodData);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        return food.map(Food::getFoodData);
    }

    @Override
    public Optional<FoodData> createFood(FoodData foodData){

        if (foodData == null || foodData.getCategory() == null || foodData.getName() == null){
            return Optional.empty();
        }
        else {
            Food food = new Food();

            food.setFoodData(foodData);

            food = foodRepository.save(food);

            food
                    .getFoodData()
                    .setId(food
                            .getId());

            foodRepository.save(food);

            return Optional.of(food.getFoodData());
        }
    }

    @Override
    public Boolean deleteFood(Long idFoodData){

        try {
            if (foodRepository.findById(idFoodData).isPresent()) {
                foodRepository.deleteById(idFoodData);
                return true;
            }
            else {
                return false;
            }
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }

    @Override
    public Optional<List<FoodData>> provideListFoodStartWith(String startNameOfFood){

        List<FoodData> fitFoods = new ArrayList<>();

        StreamSupport.stream(foodRepository.findAll().spliterator(), true)

                .filter(food -> (food.getFoodData().getName().length() >= startNameOfFood.length()))

                .filter(food -> food.getFoodData().getName().startsWith(startNameOfFood))

                .forEach(food -> fitFoods.add(food.getFoodData()));

        return Optional.of(fitFoods);
    }

    @Override
    public Optional<FoodData> updateFood(Long idFoodData, FoodData newFoodData){

        Optional<Food> oldFood;

        try {
            oldFood = foodRepository.findById(idFoodData);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        if (oldFood.isPresent() && newFoodData.getName() != null && newFoodData.getCategory() != null){

            Long id = oldFood
                    .get()
                    .getFoodData()
                    .getId();

            newFoodData
                    .setId(id);

            oldFood
                    .get()
                    .setFoodData(newFoodData);

            foodRepository.save(oldFood.get());

            return Optional.of(oldFood.get().getFoodData());
        }
        else {
            return Optional.empty();
        }
    }
}