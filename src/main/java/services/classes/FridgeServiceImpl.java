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
    public List<ProductByFridgeData> provideAllProductByFridge(Long idUserInfo) {

        List<ProductByFridgeData> productByFridgeDataList = new ArrayList<>();

        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return null;
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

            return productByFridgeDataList;
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean deleteAllProductByFridge(Long idUserInfo) {

        Optional<UserInfo> userInfo;

        try {
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return false;
        }

        if (userInfo.isPresent()){

            userInfo
                    .get()
                    .getFridge()
                    .getProducts()
                    .clear();

            userInfoRepository.save(userInfo.get());

            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public ProductByFridgeData addProductByFridge(Long idUserInfo, ProductByFridgeData productByFridgeData) {

        if (productByFridgeData == null){
            return null;
        }

        Optional<UserInfo> userInfo;
        Optional<Food> food = findCorrectFood(productByFridgeData);

        try {
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (food.isPresent() && userInfo.isPresent()){

            return saveProductByFridge(food.get(), userInfo.get(), productByFridgeData)
                    .getProductByFridgeData();
        }
        else {
            return null;
        }
    }

    private ProductByFridge saveProductByFridge(Food food, UserInfo userInfo, ProductByFridgeData productByFridgeData) {

        if (food == null || userInfo == null || productByFridgeData == null){
            return null;
        }

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

        userInfoRepository.save(userInfo);

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
    public Boolean deleteProductByFridge(Long idProductByFridge) {

        try {
            Optional<ProductByFridge> productByFridge = productByFridgeRepository.findById(idProductByFridge);

            if (productByFridge.isPresent()){

                productByFridge
                        .get()
                        .getFridge()
                        .getProducts()
                        .remove(productByFridge.get());

                productByFridgeRepository
                        .deleteById(idProductByFridge);

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
    public ProductByFridgeData provideProductByFridge(Long idProductByFridge) {

        try {
            return productByFridgeRepository
                    .findById(idProductByFridge)
                    .map(ProductByFridge::getProductByFridgeData)
                    .orElse(null);
        }
        catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public ProductByFridgeData updateProductByFridge(Long idProductByFridge, ProductByFridgeData newProductByFridgeData) {

        Optional<ProductByFridge> oldProductByFridge;

        try {
            oldProductByFridge = productByFridgeRepository.findById(idProductByFridge);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (oldProductByFridge.isPresent() && newProductByFridgeData != null){

            newProductByFridgeData
                    .setId(oldProductByFridge
                            .get()
                            .getProductByFridgeData()
                            .getId());

            oldProductByFridge
                    .get()
                    .setProductByFridgeData(newProductByFridgeData);

            productByFridgeRepository.save(oldProductByFridge.get());

            return oldProductByFridge.get().getProductByFridgeData();
        }
        else {
            return null;
        }
    }
}