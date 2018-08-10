package controllers;

import entities.data.ProductByFridgeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.Interfaces.FridgeService;

import java.util.List;

@RestController
public class FridgeController {

    private static final String FRIDGE_PATH = Resources.FRIDGE_PREFIX;

    private final FridgeService fridgeService;

    @Autowired
    public FridgeController(FridgeService fridgeService) {

        this.fridgeService = fridgeService;
    }

    @GetMapping(FRIDGE_PATH + "new")
    public @ResponseBody
    BaseResponse<ProductByFridgeData> addProductToFridge(@PathVariable Long id, @RequestBody ProductByFridgeData productByFridgeData) {

        return new BaseResponse<>(fridgeService.addProductByFridge(id, productByFridgeData));
    }

    @DeleteMapping(FRIDGE_PATH + "{id}")
    public @ResponseBody
    BaseResponse deleteProductByFridge(@PathVariable(name = "id") Long id) {

        return new BaseResponse(fridgeService.deleteProductByFridge(id));
    }

    @GetMapping(FRIDGE_PATH + "{id}")
    public @ResponseBody
    BaseResponse<ProductByFridgeData> provideProductByFridge(@PathVariable(name = "id") Long id) {

        return new BaseResponse<>(fridgeService.provideProductByFridge(id));
    }

    @PatchMapping(FRIDGE_PATH + "{id}")
    public @ResponseBody
    BaseResponse<ProductByFridgeData> updateProductByFridge(@PathVariable(name = "id") Long id, @RequestBody ProductByFridgeData newProductByFridgeData) {

        return new BaseResponse<>(fridgeService.updateProductByFridge(id, newProductByFridgeData));
    }

    @GetMapping(FRIDGE_PATH)
    public @ResponseBody
    BaseResponse<List<ProductByFridgeData>> provideListProductByFridge(@PathVariable(name = "idUser") Long id) {

        return new BaseResponse<>(fridgeService.provideAllProductByFridge(id));
    }

    @DeleteMapping(FRIDGE_PATH)
    public @ResponseBody
    BaseResponse deleteAllProduct(@PathVariable(name = "idUser") Long id) {

        return new BaseResponse(fridgeService.deleteAllProductByFridge(id));
    }
}