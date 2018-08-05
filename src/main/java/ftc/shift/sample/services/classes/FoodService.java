//package ftc.shift.sample.services.classes;
//
//import ftc.shift.sample.entities.Food;
//import ftc.shift.sample.repositories.interfaces.FoodRepository;
//import ftc.shift.sample.services.Interfaces.FoodServiceInterface;
//import lombok.NonNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Locale;
//import java.util.TreeMap;
//
//@Service
//public class FoodService implements FoodServiceInterface {
//
//    private final FoodRepository foodRepository;
//
//    @Autowired
//    public FoodService(final FoodRepository foodRepository) {
//        this.foodRepository = foodRepository;
//    }
//
//    @Override
//    public ArrayList<Food> getListFoodStartWith(@NonNull String startNameOfFood){
//
//        ArrayList<Food> list = new ArrayList<>();
//        int length = startNameOfFood.length();
//        startNameOfFood = startNameOfFood.toLowerCase(Locale.ENGLISH);
//
//        for (String idFood : foodRepository.getAllFoods().keySet()) {
//            if (idFood.length() >= length && idFood.startsWith(startNameOfFood)){
//                list.add(foodRepository.fetchFood(idFood));
//            }
//        }
//        if (list.isEmpty())
//            throw new IllegalArgumentException("Продуктов с таким именем нет в базе");
//        else return list;
//
//    }
//
//    @Override
//    public Food provideFood(@NonNull String idFood) {
//
//        if (foodRepository.getAllFoods().containsKey(idFood))
//            return foodRepository.fetchFood(idFood);
//        else throw new IllegalArgumentException("Такого food не существует");
//    }
//
//    @Override
//    public Food updateFood(@NonNull Food food) {
//
//        foodRepository.updateFood(food);
//        return food;
//    }
//
//    @Override
//    public void deleteFood(@NonNull String idFood) {
//
//        if (foodRepository.getAllFoods().containsKey(idFood))
//            foodRepository.deleteFood(idFood);
//        else throw new IllegalArgumentException("Такого food не существовало");
//    }
//
//    @Override
//    public Food createFood(@NonNull Food food) {
//
//        foodRepository.createFood(food);
//        return food;
//    }
//
//    @Override
//    public TreeMap<String,Food> provideFoods() {
//        return foodRepository.getAllFoods();
//    }
//}