package services.classes;

import entities.Food;
import entities.ProductByFridge;
import entities.UserInfo;
import entities.data.ProductByFridgeData;
import repositories.FoodRepository;
import repositories.ProductByFridgeRepository;
import repositories.UserInfoRepository;
import services.Interfaces.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class FridgeServiceImpl implements FridgeService {

    private final UserInfoRepository userInfoRepository;
    private final ProductByFridgeRepository productByFridgeRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public FridgeServiceImpl(UserInfoRepository userInfoRepository, ProductByFridgeRepository productByFridgeRepository, FoodRepository foodRepository) {
        this.userInfoRepository = userInfoRepository;
        this.productByFridgeRepository = productByFridgeRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public Optional<List<ProductByFridgeData>> provideAllProductByFridge(Long idUserInfo) {

        List<ProductByFridgeData> productByFridgeDataList = new ArrayList<>();

        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        if (userInfo.isPresent()){

            userInfo
                    .get()
                    .getFridge()
                    .getProducts()
                    .parallelStream()
                    .forEach(productByFridge -> productByFridgeDataList
                            .add(productByFridge
                                    .getProductByFridgeData()));

            return Optional.of(productByFridgeDataList);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean clearFridge(Long idUserInfo) {

        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return false;
        }

        if (userInfo.isPresent()){
            userInfo.get().getFridge().getProducts().clear();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Optional<ProductByFridgeData> addProductByFridgeToFridge(Long idUserInfo, ProductByFridgeData productByFridgeData) {

        Optional<UserInfo> userInfo;
        Optional<Food> food = findCorrectFood(productByFridgeData);

        try {
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        if (food.isPresent() && userInfo.isPresent()){

            ProductByFridge productByFridge = saveProductByFridge(food.get(), userInfo.get(), productByFridgeData);

            return Optional.of(productByFridge.getProductByFridgeData());
        }
        else {
            return Optional.empty();
        }
    }

    private ProductByFridge saveProductByFridge(Food food, UserInfo userInfo, ProductByFridgeData productByFridgeData) {

        ProductByFridge productByFridge = new ProductByFridge();

        productByFridge
                .setFood(food);

        productByFridge
                .setFridge(userInfo
                        .getFridge());

        productByFridge.setProductByFridgeData(productByFridgeData);

        productByFridge = productByFridgeRepository.save(productByFridge);

        productByFridge
                .getProductByFridgeData()
                .setId(productByFridge
                        .getId());

        productByFridgeRepository
                .save(productByFridge);

        userInfo
                .getFridge()
                .getProducts()
                .add(productByFridge);

        return productByFridge;
    }

    private Optional<Food> findCorrectFood(ProductByFridgeData productByFridgeData) {

        return StreamSupport.stream(foodRepository.findAll().spliterator(), true)

                .filter(f -> f
                        .getFoodData()
                        .getName()
                        .equals(productByFridgeData
                                .getName()))

                .findFirst();
    }

    @Override
    public Boolean deleteProductByFridgeFromFridge(Long idProductByFridgeData) {

        try {
            Optional<ProductByFridge> productByFridge = productByFridgeRepository.findById(idProductByFridgeData);

            if (productByFridge.isPresent()){

                productByFridge
                        .get()
                        .getFridge()
                        .getProducts()
                        .remove(productByFridge.get());

                productByFridgeRepository
                        .deleteById(idProductByFridgeData);

                return true;
            }
            else {
                return false;
            }
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }

    @Override
    public Optional<ProductByFridgeData> provideProductByFridge(Long idProductByFridgeData) {

        Optional<ProductByFridge> productByFridge;

        try {
            productByFridge = productByFridgeRepository.findById(idProductByFridgeData);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        return productByFridge.map(ProductByFridge::getProductByFridgeData);
    }

    @Override
    public Optional<ProductByFridgeData> updateProductByFridge(Long idProductByFridgeData, ProductByFridgeData newProductByFridgeData) {

        Optional<ProductByFridge> oldProductByFridge;

        try {
            oldProductByFridge = productByFridgeRepository.findById(idProductByFridgeData);
        }
        catch (IllegalArgumentException e){
            return Optional.empty();
        }

        if (oldProductByFridge.isPresent()){

            Long id = oldProductByFridge
                    .get()
                    .getProductByFridgeData()
                    .getId();

            newProductByFridgeData
                    .setId(id);

            oldProductByFridge
                    .get()
                    .setProductByFridgeData(newProductByFridgeData);

            productByFridgeRepository.save(oldProductByFridge.get());

            return Optional.of(oldProductByFridge.get().getProductByFridgeData());
        }
        else {
            return Optional.empty();
        }
    }
}