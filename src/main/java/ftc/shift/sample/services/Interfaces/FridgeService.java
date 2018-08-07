package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.ProductByFridge;
import lombok.NonNull;

import java.util.Collection;

public interface FridgeService {

    Collection<ProductByFridge> provideAllProductByFridge(@NonNull Long idUserInfo);
}