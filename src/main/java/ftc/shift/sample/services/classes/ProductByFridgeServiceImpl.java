package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.ProductByFridge;
import ftc.shift.sample.repositories.ProductByFridgeRepository;
import ftc.shift.sample.services.Interfaces.ProductByFridgeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductByFridgeServiceImpl implements ProductByFridgeService {

    private final ProductByFridgeRepository productByFridgeRepository;

    @Autowired
    public ProductByFridgeServiceImpl(final ProductByFridgeRepository productByFridgeRepository) {
        this.productByFridgeRepository = productByFridgeRepository;
    }

    @Override
    public void removeProductByFridge(@NonNull Long idProductByFridge) {
        productByFridgeRepository.deleteById(idProductByFridge);
    }

    @Override
    public void updateAllAmount(Long idProductByFridge, Double newAllAmount) {

    }

    @Override
    public Double provideAllAmount(Long idProductByFridge) {
        return null;
    }

    @Override
    public void updateReservedAmount(Long idProductByFridge, Double newReservedAmount) {

    }

    @Override
    public Double provideReservedAmount(Long idProductByFridge) {
        return null;
    }

    @Override
    public ProductByFridge provideProductByFridge(@NonNull Long idProductByFridge) {
        return productByFridgeRepository.findById(idProductByFridge).get();
    }
}
