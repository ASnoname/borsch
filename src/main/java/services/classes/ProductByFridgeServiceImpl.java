package services.classes;

import entities.ProductByFridge;
import repositories.FoodRepository;
import repositories.ProductByFridgeRepository;
import repositories.UserInfoRepository;
import services.Interfaces.ProductByFridgeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductByFridgeServiceImpl implements ProductByFridgeService {

    private final ProductByFridgeRepository productByFridgeRepository;
    private final UserInfoRepository userInfoRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public ProductByFridgeServiceImpl(final ProductByFridgeRepository productByFridgeRepository, UserInfoRepository userInfoRepository, FoodRepository foodRepository) {

        this.productByFridgeRepository = productByFridgeRepository;
        this.userInfoRepository = userInfoRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public Long createProductByFridge(@NonNull Long idUserInfo, @NonNull Long idFood) {

        ProductByFridge productByFridge = new ProductByFridge();

        productByFridge
                .setFood(foodRepository
                        .findById(idFood)
                        .get());

        productByFridge
                .setFridge(userInfoRepository
                        .findById(idUserInfo)
                        .get()
                        .getFridge());

        productByFridge
                .getFridge()
                .getProducts()
                .add(productByFridge);

        foodRepository
                .findById(idFood)
                .get()
                .getProducts()
                .add(productByFridge);

        productByFridgeRepository
                .save(productByFridge);

        return productByFridge.getId();
    }

    @Override
    public void deleteProductByFridge(@NonNull Long idProductByFridge) {

        ProductByFridge productByFridge = productByFridgeRepository.findById(idProductByFridge).get();

        productByFridge
                .getFridge()
                .getProducts()
                .remove(productByFridge);

        productByFridge
                .getFood()
                .getProducts()
                .remove(productByFridge);

        productByFridgeRepository.deleteById(idProductByFridge);
    }

    @Override
    public ProductByFridge provideProductByFridge(@NonNull Long idProductByFridge) {

        return productByFridgeRepository
                .findById(idProductByFridge)
                .get();
    }
}
