//package ftc.shift.sample.services.Interfaces;
//
//import ftc.shift.sample.entities.Fridge;
//import ftc.shift.sample.entities.Product;
//import lombok.NonNull;
//
//public interface FridgeServiceInterface {
//
//    Fridge provideFridge(@NonNull String idUser);
//
//    Fridge addProductInFridge(@NonNull String idUser,@NonNull  Product product);
//
//    //IllegalArgumentException("Такого продукта нет в холодильнике данного пользователя")
//    Fridge removeProductFromFridge(@NonNull String idUser,@NonNull  String idProduct);
//
//    //IllegalArgumentException("Такого продукта нет в холодильнике данного пользователя")
//    Product getProductFromFridge(@NonNull String idUser,@NonNull String idProduct);
//}