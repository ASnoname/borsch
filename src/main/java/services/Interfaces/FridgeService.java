package services.Interfaces;

import entities.data.ProductByFridgeData;
import java.util.List;
import java.util.Optional;

public interface FridgeService {

    Optional<ProductByFridgeData> addProductByFridgeToFridge(Long idUserInfo, ProductByFridgeData productByFridgeData);

    Boolean deleteProductByFridgeFromFridge(Long idProductByFridgeData);

    Optional<ProductByFridgeData> provideProductByFridge(Long idProductByFridgeData);

    Optional<ProductByFridgeData> updateProductByFridge(Long idProductByFridgeData, ProductByFridgeData newProductByFridgeData);

    Optional<List<ProductByFridgeData>> provideAllProductByFridge(Long idUserInfo);

    Boolean clearFridge(Long idUserInfo);
}