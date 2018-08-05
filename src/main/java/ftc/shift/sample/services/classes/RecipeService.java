//package ftc.shift.sample.services.classes;
//
//import ftc.shift.sample.entities.Product;
//import ftc.shift.sample.entities.Recipe;
//import ftc.shift.sample.entities.StateByProduct;
//import ftc.shift.sample.entities.User;
//import ftc.shift.sample.repositories.interfaces.UserRepository;
//import ftc.shift.sample.services.Interfaces.RecipeServiceInterface;
//import lombok.NonNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import static ftc.shift.sample.entities.StateByProduct.ACCEPTED;
//import static ftc.shift.sample.entities.StateByProduct.DENIED;
//import static ftc.shift.sample.entities.StateByProduct.WAITING;
//
//@Service
//public class RecipeService implements RecipeServiceInterface {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public RecipeService(final UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    private User provideUser(@NonNull String idUser) {
//
//        if (userRepository.getAllUsers().containsKey(idUser))
//            return userRepository.fetchUser(idUser);
//        else throw new IllegalArgumentException("Пользователя с таким логином не существует");
//    }
//
//    private void updateUser(@NonNull User user) {
//
//        userRepository.updateUser(user);
//    }
//
//    @Override
//    public HashMap<String,Recipe> getAllMyRecipes(@NonNull String idUser) {
//        return provideUser(idUser)
//                .getMyRecipes();
//    }
//
//    @Override
//    public HashMap<String,Recipe> getAllNotMyRecipes(@NonNull String idUser) {
//        return provideUser(idUser)
//                .getNotMyRecipes();
//    }
//
//    @Override
//    public void addRecipeToMyRecipes(@NonNull Recipe recipe) {
//
//        provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .put(recipe.getName(),recipe);
//        updateUser(userRepository.fetchUser(recipe.getIdPovar()));
//    }
//
//    @Override
//    public void addRecipeToNotMyRecipes(@NonNull Recipe recipe, @NonNull String idUser, @NonNull Product product) {
//
//        provideUser(idUser)
//                .getNotMyRecipes()
//                .put(recipe.getName(),recipe);
//        provideUser(idUser)
//                .getRecipeState()
//                .put(recipe.getName(),WAITING);
//        updateUser(userRepository.fetchUser(recipe.getIdPovar()));
//
//        addUserToAllUsersForProductIdForRecipeId(recipe,idUser,product);
//    }
//
//    @Override
//    public HashMap<String,Recipe> getAllRecipesForUser(@NonNull String idUser){
//
//        HashMap<String,Recipe> myLenta = new HashMap<>();
//
//        for (Map.Entry<String,Product> myProduct : provideUser(idUser).getFridge().getProducts().entrySet()) {
//
//            for (Map.Entry<String,User> otherUser: userRepository.getAllUsers().entrySet()) {
//
//                for (Map.Entry<String,Recipe> recipeOtherUser: otherUser.getValue().getMyRecipes().entrySet()) {
//
//                    for (Product currentProduct : recipeOtherUser.getValue().getProductList()) {
//
//                        if (myProduct.getValue().equals(currentProduct)){
//
//                            myLenta.put(recipeOtherUser.getKey(),recipeOtherUser.getValue());
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        return myLenta;
//    }
//
//    @Override
//    public void addUserToAllUsersForProductIdForRecipeId(@NonNull Recipe recipe, @NonNull String idUser, @NonNull Product product){
//
//        getAllUsersForProductIdForRecipeId(recipe,product)
//                .put(idUser,provideUser(idUser));
//    }
//
//    @Override
//    public void removeRecipeFromMyRecipes(@NonNull String idUser, @NonNull String idRecipe) {
//
//        if (provideUser(idUser).getMyRecipes().containsKey(idRecipe)) {
//            provideUser(idUser).getMyRecipes().remove(idRecipe);
//            updateUser(userRepository.fetchUser(idUser));
//        }
//        else {
//            throw new IllegalArgumentException("Такого рецепта не существовало");
//        }
//    }
//
//    @Override
//    public void removeRecipeFromNotMyRecipes(@NonNull String idUser, @NonNull String idRecipe) {
//
//        if (provideUser(idUser).getNotMyRecipes().containsKey(idRecipe)) {
//            provideUser(idUser).getNotMyRecipes().remove(idRecipe);
//            updateUser(userRepository.fetchUser(idUser));
//        }
//        else {
//            throw new IllegalArgumentException("Такого рецепта не существовало");
//        }
//    }
//
//    @Override
//    public void changeRecipeState(@NonNull String idUser,@NonNull Recipe recipe,@NonNull StateByProduct newState) {
//
//        provideUser(idUser)
//                .getRecipeState()
//                .put(recipe.getIdRecipe(),newState);
//        updateUser(provideUser(idUser));
//    }
//
//    @Override
//    public ArrayList<Product> getProductsFromRecipe(@NonNull Recipe recipe) {
//        return provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getName())
//                .getProductList();
//    }
//
//    @Override
//    public void addProductToMyRecipe(@NonNull Recipe recipe,@NonNull Product product) {
//
//        provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getName())
//                .getProductList()
//                .add(product);
//
//        provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getIdRecipe())
//                .getListUsersForEachProduct()
//                .put(product.getId(),new HashMap<>());
//        updateUser(provideUser(recipe.getIdPovar()));
//    }
//
//    @Override
//    public void removeProductFromMyRecipe(@NonNull Recipe recipe,@NonNull Product product) {
//
//        provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getName())
//                .getProductList()
//                .remove(product);
//        updateUser(provideUser(recipe.getIdPovar()));
//    }
//
//    @Override
//    public HashMap<String, String> getFinalUsersFromRecipe(@NonNull Recipe recipe) {
//        return provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getName())
//                .getFinalUserList();
//    }
//
//    @Override
//    public void addUserToFinalListRecipe(@NonNull Recipe recipe,@NonNull Product product,@NonNull String idUser) {
//
//        provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getIdRecipe())
//                .getFinalUserList()
//                .put(product.getId(),idUser);
//
//        changeRecipeState(idUser,recipe,ACCEPTED);
//        updateUser(provideUser(recipe.getIdPovar()));
//
//        if (getAllUsersForProductIdForRecipeId(recipe, product).isEmpty()){
//
//            throw new IllegalArgumentException("По этому продукту нет заявок");
//        }
//
//        for (Map.Entry<String, User> entry : getAllUsersForProductIdForRecipeId(recipe, product).entrySet()) {
//
//            if (!idUser.equals(entry.getKey())){
//                deleteUserFromListForProductIdForRecipeId(recipe,product,entry.getKey());
//                updateUser(provideUser(idUser));
//            }
//        }
//    }
//
//    @Override
//    public void removeUserFromFinalListRecipe(@NonNull Recipe recipe,@NonNull Product product,@NonNull String idUser) {
//
//        provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getName())
//                .getFinalUserList()
//                .remove(product.getId(),idUser);
//
//        updateUser(provideUser(recipe.getIdPovar()));
//
//        changeRecipeState(idUser,recipe,WAITING);
//
//        updateUser(provideUser(idUser));
//    }
//
//    @Override
//    public HashMap<String,User> getAllUsersForProductIdForRecipeId(@NonNull Recipe recipe, @NonNull Product product) {
//
//        return provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getName())
//                .getListUsersForEachProduct()
//                .get(product.getId());
//    }
//
//    @Override
//    public void deleteUserFromListForProductIdForRecipeId(@NonNull Recipe recipe,@NonNull Product product,@NonNull String idUser){
//
//        provideUser(recipe.getIdPovar())
//                .getMyRecipes()
//                .get(recipe.getName())
//                .getListUsersForEachProduct()
//                .get(product.getId())
//                .remove(idUser);
//
//        updateUser(provideUser(recipe.getIdPovar()));
//
//        changeRecipeState(idUser,recipe,DENIED);
//
//        updateUser(provideUser(idUser));
//    }
//
//    @Override
//    public StateByProduct getRecipeState(@NonNull String userId,@NonNull Recipe recipe) {
//        return provideUser(userId).getRecipeState().get(recipe.getName());
//    }
//}
