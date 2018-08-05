//package ftc.shift.sample.services.Interfaces;
//
//import ftc.shift.sample.entities.Product;
//import ftc.shift.sample.entities.Recipe;
//import ftc.shift.sample.entities.StateByProduct;
//import ftc.shift.sample.entities.User;
//import lombok.NonNull;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public interface RecipeServiceInterface {
//
//    HashMap<String,Recipe> getAllRecipesForUser(@NonNull String idUser);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    HashMap<String,Recipe> getAllMyRecipes(@NonNull String idUser);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    HashMap<String,Recipe> getAllNotMyRecipes(@NonNull String idUser);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void addRecipeToMyRecipes(@NonNull Recipe recipe);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void addRecipeToNotMyRecipes(@NonNull Recipe recipe, @NonNull String idUser, @NonNull Product product);
//
//    //IllegalArgumentException("Такого рецепта не существовало")
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void removeRecipeFromMyRecipes(@NonNull String idUser, @NonNull String idRecipe);
//
//    //IllegalArgumentException("Такого рецепта не существовало")
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void removeRecipeFromNotMyRecipes(@NonNull String idUser, @NonNull String idRecipe);
//
//    void addUserToAllUsersForProductIdForRecipeId(@NonNull Recipe recipe, @NonNull String idUser, @NonNull Product product);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void changeRecipeState(@NonNull String idUser,@NonNull Recipe recipe,@NonNull StateByProduct newState);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    ArrayList<Product> getProductsFromRecipe(@NonNull Recipe recipe);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void addProductToMyRecipe(@NonNull Recipe recipe,@NonNull Product product);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void removeProductFromMyRecipe(@NonNull Recipe recipe,@NonNull Product product);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    HashMap<String,String> getFinalUsersFromRecipe(@NonNull Recipe recipe);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void addUserToFinalListRecipe(@NonNull Recipe recipe,@NonNull Product product,@NonNull String idUser);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void removeUserFromFinalListRecipe(@NonNull Recipe recipe,@NonNull Product product,@NonNull String idUser);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    HashMap<String,User> getAllUsersForProductIdForRecipeId(@NonNull Recipe recipe, @NonNull Product product);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    void deleteUserFromListForProductIdForRecipeId(@NonNull Recipe recipe,@NonNull Product product,@NonNull String idUser);
//
//    //IllegalArgumentException("Пользователя с таким логином не существует")
//    StateByProduct getRecipeState(@NonNull String userId,@NonNull Recipe recipe);
//}
