package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.ProductByFridge;
import lombok.NonNull;

import java.util.Collection;

public interface FridgeService {

    void createProductByFridge(@NonNull Long idUserInfo, @NonNull ProductByFridge productByFridge);

    Collection<ProductByFridge> provideAllProductByFridge(@NonNull Long idUserInfo);
}