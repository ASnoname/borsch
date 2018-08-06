package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.ProductByRecipe;
import ftc.shift.sample.entities.UserInfo;
import ftc.shift.sample.repositories.ProductByRecipeRepository;
import ftc.shift.sample.repositories.UserInfoRepository;
import ftc.shift.sample.services.Interfaces.ProductByRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
    public void updateProductByRecipe(ProductByRecipe productByRecipe) {

        productByRecipeRepository
                .save(productByRecipe);
    }

    @Override
    public void deleteProductByRecipe(Long idProductByRecipe) {

        productByRecipeRepository
                .deleteById(idProductByRecipe);
    }

    @Override
    public ProductByRecipe getProductByRecipe(Long idProductByRecipe) {

        return productByRecipeRepository
                .findById(idProductByRecipe)
                .get();
    }

    @Override
    public UserInfo getFinalUserInfo(Long idProductByRecipe) {

        return productByRecipeRepository
                .findById(idProductByRecipe)
                .get()
                .getUserInfo();
    }

    @Override
    public void updateFinalUserInfo(Long idProductByRecipe, Long idUserInfo) {

        productByRecipeRepository
                .findById(idProductByRecipe)
                .get()
                .setUserInfo(userInfoRepository
                        .findById(idUserInfo)
                        .get());
    }

    @Override
    public void clearFinalUserInfo(Long idProductByRecipe) {

        productByRecipeRepository
                .findById(idProductByRecipe)
                .get()
                .setUserInfo(null);
    }

    @Override
    public Collection<UserInfo> getOffers(Long idProductByRecipe) {

        return productByRecipeRepository
                .findById(idProductByRecipe)
                .get()
                .getOffers();
    }

    @Override
    public void addOffer(Long idProductByRecipe, Long idUserInfo) {

        productByRecipeRepository
                .findById(idProductByRecipe)
                .get()
                .getOffers()
                .add(userInfoRepository
                        .findById(idUserInfo)
                        .get());
    }

    @Override
    public void clearOffers(Long idProductByRecipe) {

        productByRecipeRepository
                .findById(idProductByRecipe)
                .get()
                .setOffers(null);
    }

    @Override
    public void deleteOffer(Long idProductByRecipe, Long idUserInfo) {

        productByRecipeRepository
                .findById(idProductByRecipe)
                .get()
                .getOffers()
                .remove(userInfoRepository
                        .findById(idUserInfo)
                        .get());
    }
}
