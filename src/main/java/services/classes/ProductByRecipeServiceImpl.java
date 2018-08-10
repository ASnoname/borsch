package services.classes;

import entities.ProductByRecipe;
import entities.UserInfo;
import entities.data.ProductByRecipeData;
import entities.data.UserInfoData;
import repositories.ProductByRecipeRepository;
import repositories.UserInfoRepository;
import services.Interfaces.ProductByRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductByRecipeServiceImpl implements ProductByRecipeService {

    private final ProductByRecipeRepository productByRecipeRepository;
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public ProductByRecipeServiceImpl(final ProductByRecipeRepository productByRecipeRepository, UserInfoRepository userInfoRepository) {

        this.productByRecipeRepository = productByRecipeRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public ProductByRecipeData addProductByRecipe(Long idRecipe, ProductByRecipeData productByRecipeData) {
        return null;
    }

    @Override
    public Boolean deleteProductByRecipe(Long idProductByRecipe) {
        return null;
    }

    @Override
    public ProductByRecipeData provideProductByRecipe(Long idProductByRecipe) {
        return null;
    }

    @Override
    public ProductByRecipeData updateProductByRecipe(Long idProductByRecipe, ProductByRecipeData newProductByRecipeData) {
        return null;
    }

    @Override
    public List<UserInfoData> provideOffers(Long idProductByRecipe) {

        List<UserInfoData> userInfoDataList = new ArrayList<>();

        Optional<ProductByRecipe> productByRecipe;

        try {
            productByRecipe = productByRecipeRepository.findById(idProductByRecipe);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (productByRecipe.isPresent()){

            productByRecipe
                    .get()
                    .getOffers()
                    .parallelStream()
                    .forEach(userInfo -> userInfoDataList.add(userInfo.getUserInfoData()));

            return userInfoDataList;
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean deleteUserInfoFromOffers(Long idProductByRecipe, Long idUserInfo) {

        Optional<ProductByRecipe> productByRecipe;
        Optional<UserInfo> userInfo;

        try {
            productByRecipe = productByRecipeRepository.findById(idProductByRecipe);
            userInfo = userInfoRepository.findById(idUserInfo);
        }
        catch (IllegalArgumentException e){
            return null;
        }

        if (productByRecipe.isPresent() && userInfo.isPresent()){

            productByRecipe
                    .get()
                    .getOffers()
                    .remove(userInfo
                            .get());
//
//            return userInfo
//                    .get()
//                    .getUserInfoData();
            return null;
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean clearOffers(Long idProductByRecipe) {
        return null;
    }

    @Override
    public Boolean clearFinalUserInfo(Long idProductByRecipe) {
        return null;
    }

    @Override
    public UserInfoData changeFinalUserInfo(Long idProductByRecipe, Long newIdUserInfo) {
        return null;
    }
}
