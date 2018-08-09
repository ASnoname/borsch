package controllers;

import entities.data.ProductByFridgeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.Interfaces.FridgeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class FridgeController {

    private static final String FRIDGE_PATH = Resources.FRIDGE_PREFIX;

    private final FridgeService fridgeService;

    @Autowired
    public FridgeController(FridgeService fridgeService) {
        this.fridgeService = fridgeService;
    }

    @GetMapping(FRIDGE_PATH)
    public @ResponseBody
    BaseResponse<ProductByFridgeData> addProductToFridge(final HttpServletRequest request, @RequestBody ProductByFridgeData productByFridgeData) {

        BaseResponse<ProductByFridgeData> response = new BaseResponse<>();

        Optional<ProductByFridgeData> resultProductByFridgeData
                = fridgeService.addProductByFridgeToFridge(Long.valueOf(request.getHeader("idUserInfo")), productByFridgeData);

        if (resultProductByFridgeData.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(resultProductByFridgeData.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Не удалось добавить продукт!");
        }

        return response;
    }

    @DeleteMapping(FRIDGE_PATH + "{idProductByFridgeData}")
    public @ResponseBody
    BaseResponse deleteProductByFridge(@PathVariable Long idProductByFridgeData) {

        BaseResponse response = new BaseResponse();

        if (fridgeService.deleteProductByFridgeFromFridge(idProductByFridgeData)) {
            response.setStatus(Resources.SUCCESS_STATUS);
        }
        else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Продукт не удален!");
        }

        return response;
    }

    @GetMapping(FRIDGE_PATH + "{idProductByFridgeData}")
    public @ResponseBody
    BaseResponse<ProductByFridgeData> provideProductByFridge(@PathVariable Long idProductByFridgeData) {

        BaseResponse<ProductByFridgeData> response = new BaseResponse<>();

        Optional<ProductByFridgeData> productByFridgeData = fridgeService.provideProductByFridge(idProductByFridgeData);

        if (productByFridgeData.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(productByFridgeData.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Не удалось получить продукт по этому id!");
        }

        return response;
    }

    @PatchMapping(FRIDGE_PATH + "{idProductByFridgeData}")
    public @ResponseBody
    BaseResponse<ProductByFridgeData> updateProductByFridge(@PathVariable Long idProductByFridgeData, @RequestBody ProductByFridgeData newProductByFridgeData) {

        BaseResponse<ProductByFridgeData> response = new BaseResponse<>();

        Optional<ProductByFridgeData> resultProductByFridgeData
                = fridgeService.updateProductByFridge(idProductByFridgeData, newProductByFridgeData);

        if (resultProductByFridgeData.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(resultProductByFridgeData.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Не удалось обновить продукт!");
        }

        return response;
    }

    @GetMapping(FRIDGE_PATH + "{idUserInfoData}" + "/list")
    public @ResponseBody
    BaseResponse<List<ProductByFridgeData>> provideListProductByFridge(@PathVariable Long idUserInfo) {

        BaseResponse<List<ProductByFridgeData>> response = new BaseResponse<>();

        Optional<List<ProductByFridgeData>> products = fridgeService.provideAllProductByFridge(idUserInfo);

        if (products.isPresent()) {
            response.setStatus(Resources.SUCCESS_STATUS);
            response.setData(products.get());
        } else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Пользователь с таким id не найден!");
        }

        return response;
    }

    @DeleteMapping(FRIDGE_PATH)
    public @ResponseBody
    BaseResponse deleteFridge(final HttpServletRequest request) {

        BaseResponse response = new BaseResponse();

        if (fridgeService.clearFridge(Long.valueOf(request.getHeader("idUserInfo")))) {
            response.setStatus(Resources.SUCCESS_STATUS);
        }
        else {
            response.setStatus(Resources.UNSUCCESS_STATUS);
            response.setMessage("Пользователь с таким id не найден!");
        }

        return response;
    }
}
