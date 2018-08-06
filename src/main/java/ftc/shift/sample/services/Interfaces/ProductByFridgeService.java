package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.ProductByFridge;
import lombok.NonNull;

public interface ProductByFridgeService {

    void removeProductByFridge(@NonNull Long idProductByFridge);

    void updateAllAmount(@NonNull Long idProductByFridge, @NonNull Double newAllAmount);

    Double provideAllAmount(@NonNull Long idProductByFridge);

    void updateReservedAmount(@NonNull Long idProductByFridge, @NonNull Double newReservedAmount);

    Double provideReservedAmount(@NonNull Long idProductByFridge);

    ProductByFridge provideProductByFridge(@NonNull Long idProductByFridge);
}
