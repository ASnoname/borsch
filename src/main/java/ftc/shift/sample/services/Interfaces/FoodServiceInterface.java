//package ftc.shift.sample.services.Interfaces;
//
//import ftc.shift.sample.entities.Food;
//import lombok.NonNull;
//
//import java.util.ArrayList;
//import java.util.TreeMap;
//
//public interface FoodServiceInterface {
//
//    //IllegalArgumentException("Продуктов с таким именем нет в базе");
//    ArrayList<Food> getListFoodStartWith(@NonNull String startNameOfFood);
//
//    //IllegalArgumentException("Такого food не существует")
//    Food provideFood(@NonNull String idFood);
//
//    Food updateFood(@NonNull Food food);
//
//    //IllegalArgumentException("Такого food не существовало")
//    void deleteFood(@NonNull String idFood);
//
//    Food createFood(@NonNull Food food);
//
//    TreeMap<String,Food> provideFoods();
//}
