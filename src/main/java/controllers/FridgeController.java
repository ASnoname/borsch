package controllers;


import entities.Fridge;
import entities.Product;
import services.Interfaces.FoodServiceInterface;
import services.Interfaces.FridgeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
public class FridgeController {


    private static final String FRIDGE_PATH = Resources.API_PREFIX + "fridge";
    private static final String FOOD_PATH = Resources.API_PREFIX + "food";

        private final FridgeServiceInterface services;
        private FoodServiceInterface foodService;

    @Autowired
    public FridgeController(FridgeServiceInterface services) {
        this.services = services;
    }

    @GetMapping(FRIDGE_PATH)
        public @ResponseBody
        BaseResponse<Collection<Product>> provideFridgeInfo(final HttpServletRequest request) {
            BaseResponse<Collection<Product>> response = new BaseResponse<>();
            Fridge fridge =services.provideFridge(request.getHeader("Login"));
            Collection<Product> list = fridge.getProducts().values();
            response.setData(list);

            return response;
        }

    @PostMapping(FRIDGE_PATH)
    public @ResponseBody
    BaseResponse<Collection<Product>> addProductToFriedge(@RequestBody Product product,final HttpServletRequest request) {
        BaseResponse<Collection<Product>> response = new BaseResponse<>();

        String login = request.getHeader("Login");
        Fridge fridge = services.addProductInFridge(request.getHeader("Login"),product);
        Collection<Product> list = fridge.getProducts().values();
        response.setData(list);
        return response;

    }
    @PostMapping(FRIDGE_PATH+"/delete")
    public @ResponseBody
    BaseResponse<Collection<Product>> removeProductToFriedge(@RequestBody Product product,final HttpServletRequest request) {
        BaseResponse<Collection<Product>> response = new BaseResponse<>();
        String login = request.getHeader("Login");
        Fridge fridge = services.removeProductFromFridge(request.getHeader("Login"),product.getFoodName());
        System.out.println(fridge.toString());
        Collection<Product> list = fridge.getProducts().values();
        response.setData(list);
        return response;

    }

}
