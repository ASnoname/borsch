package services.Interfaces;

import entities.ProductByFridge;
import lombok.NonNull;

public interface ProductByFridgeService {

    Long createProductByFridge(@NonNull Long idUserInfo, @NonNull Long idFood);

    void deleteProductByFridge(@NonNull Long idProductByFridge);

    ProductByFridge provideProductByFridge(@NonNull Long idProductByFridge);
}
