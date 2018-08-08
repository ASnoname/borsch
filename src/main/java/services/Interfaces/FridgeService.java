package services.Interfaces;

import entities.ProductByFridge;
import java.util.List;
import java.util.Optional;

public interface FridgeService {

    Optional<List<ProductByFridge>> provideAllProductByFridge(Long idUserInfo);

    Boolean clearFridge(Long idUserInfo);

    Optional<List<ProductByFridge>> addProductByFridgeToFridge(Long idUserInfo, ProductByFridge productByFridge);

    Boolean deleteProductByFridgeFromFridge(Long idProductByFridge);

    Optional<ProductByFridge> provideProductByFridge(Long idProductByFridge);

    Optional<ProductByFridge> updateProductByFridge(ProductByFridge productByFridge);
}