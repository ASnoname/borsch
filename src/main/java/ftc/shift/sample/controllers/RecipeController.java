//package ftc.shift.sample.controllers;
//
//
//import ftc.shift.sample.entities.*;
//import ftc.shift.sample.services.Interfaces.FridgeServiceInterface;
//import ftc.shift.sample.services.Interfaces.RecipeServiceInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Collection;
//
//@RestController
//public class RecipeController {
//
//
//    private static final String RECIPE_PATH = Resources.API_PREFIX + "recipe";
//
//    private final RecipeServiceInterface services;
//    private final FridgeServiceInterface serviceFridge;
//
//    @Autowired
//    public RecipeController(RecipeServiceInterface services, FridgeServiceInterface serviceFridge) {
//        this.services = services;
//        this.serviceFridge = serviceFridge;
//    }
//
//    @GetMapping(RECIPE_PATH)
//    public @ResponseBody
//    BaseResponse<Collection<Recipe>> provideRecipe(final HttpServletRequest request) {
//        BaseResponse<Collection<Recipe>> response = new BaseResponse<>();
//        Collection<Recipe> list = services.getAllMyRecipes(request.getHeader("Login")).values();
//        response.setData(list);
//
//        return response;
//    }
//
//    @PostMapping(RECIPE_PATH)
//    public @ResponseBody
//    BaseResponse<Collection<Recipe>> addRecipe(@RequestBody Recipe recipe,final HttpServletRequest request) {
//        BaseResponse<Collection<Recipe>> response = new BaseResponse<>();
//        // System.out.println(product.toString());
//        String login = request.getHeader("Login");
//        services.addRecipeToMyRecipes(recipe);
//        Collection<Recipe> list = services.getAllMyRecipes(login).values();
//        response.setData(list);
//        return response;
//
//    }
//    @GetMapping(RECIPE_PATH+"/delete/{recipeName}")
//    public @ResponseBody
//    BaseResponse<Collection<Recipe>> deleteRecipe(@PathVariable String recipeName,final HttpServletRequest request) {
//        BaseResponse<Collection<Recipe>> response = new BaseResponse<>();
//        String userName = request.getHeader("Login");
//        services.removeRecipeFromMyRecipes(userName,recipeName);
//        Collection<Recipe> list = services.getAllMyRecipes(request.getHeader("Login")).values();
//        response.setData(list);
//
//        return response;
//    }
//
//    @PostMapping(RECIPE_PATH+"/accept")
//    public @ResponseBody
//    BaseResponse<Collection<Recipe>> accepUserForRecipe(@RequestBody AcceptModel acceptModel, final HttpServletRequest request) {
//        BaseResponse<Collection<Recipe>> response = new BaseResponse<>();
//        // System.out.println(product.toString());
//        String login = request.getHeader("Login");
//        Product product = serviceFridge.getProductFromFridge(acceptModel.getUserName(),acceptModel.getProductName());
//        Recipe recipe = services.getAllMyRecipes(login).get(acceptModel.getRecipeName());
//        services.addUserToFinalListRecipe(recipe,product,acceptModel.getProductName());
//        Collection<Recipe> list = services.getAllMyRecipes(request.getHeader("Login")).values();
//        response.setData(list);
//        return response;
//
//    }
//    @PostMapping(RECIPE_PATH+"/denied")
//    public @ResponseBody
//    BaseResponse<Collection<Recipe>> deniedUserForRecipe(@RequestBody String userName,@RequestBody String productName,@RequestBody String recipeName,final HttpServletRequest request) {
//        BaseResponse<Collection<Recipe>> response = new BaseResponse<>();
//        // System.out.println(product.toString());
//        String login = request.getHeader("Login");
//        Product product = serviceFridge.getProductFromFridge(userName,productName);
//        Recipe recipe = services.getAllMyRecipes(login).get(recipeName);
//        services.deleteUserFromListForProductIdForRecipeId(recipe,product,userName);
//        Collection<Recipe> list = services.getAllMyRecipes(request.getHeader("Login")).values();
//        response.setData(list);
//        return response;
//
//    }
//
//    @PostMapping(RECIPE_PATH+"/{userName}/accepted")
//    public @ResponseBody
//    BaseResponse<Collection<Recipe>> aceptedRecipeForUser(@PathVariable String userName,@RequestBody String productName,@RequestBody String recipeName,final HttpServletRequest request) {
//        BaseResponse<Collection<Recipe>> response = new BaseResponse<>();
//        // System.out.println(product.toString());
//        String login = request.getHeader("Login");
//        Product product = serviceFridge.getProductFromFridge(login,productName);
//        Recipe recipe = services.getAllMyRecipes(userName).get(recipeName);
//        services.addRecipeToNotMyRecipes(recipe,login,product);
//        Collection<Recipe> list = services.getAllNotMyRecipes(request.getHeader("Login")).values();
//        response.setData(list);
//        return response;
//
//    }
//    @PostMapping(RECIPE_PATH+"/{userName}/denied")
//    public @ResponseBody
//    BaseResponse<Collection<Recipe>> deniedRecipeForUser(@PathVariable String userName,@RequestBody String productName,@RequestBody String recipeName,final HttpServletRequest request) {
//        BaseResponse<Collection<Recipe>> response = new BaseResponse<>();
//        String login = request.getHeader("Login");
//        Product product = serviceFridge.getProductFromFridge(login,productName);
//        Recipe recipe = services.getAllMyRecipes(userName).get(recipeName);
//        services.addRecipeToNotMyRecipes(recipe,login,product);
//        Collection<Recipe> list = services.getAllNotMyRecipes(login).values();
//        response.setData(list);
//        return response;
//
//    }
//
//
//
//}