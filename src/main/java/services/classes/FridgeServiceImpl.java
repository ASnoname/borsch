package services.classes;

import entities.ProductByFridge;
import repositories.ProductByFridgeRepository;
import repositories.UserInfoRepository;
import services.Interfaces.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FridgeServiceImpl implements FridgeService {

    private final UserInfoRepository userInfoRepository;
    private final ProductByFridgeRepository productByFridgeRepository;

    @Autowired
    public FridgeServiceImpl(UserInfoRepository userInfoRepository, ProductByFridgeRepository productByFridgeRepository) {
        this.userInfoRepository = userInfoRepository;
        this.productByFridgeRepository = productByFridgeRepository;
    }

    @Override
    public Optional<List<ProductByFridge>> provideAllProductByFridge(Long idUserInfo) {
        return Optional.empty();
    }

    @Override
    public Boolean clearFridge(Long idUserInfo) {
        return null;
    }

    @Override
    public Optional<List<ProductByFridge>> addProductByFridgeToFridge(Long idUserInfo, ProductByFridge productByFridge) {
        return Optional.empty();
    }

    @Override
    public Boolean deleteProductByFridgeFromFridge(Long idProductByFridge) {
        return null;
    }

    @Override
    public Optional<ProductByFridge> provideProductByFridge(Long idProductByFridge) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductByFridge> updateProductByFridge(ProductByFridge productByFridge) {
        return Optional.empty();
    }
}