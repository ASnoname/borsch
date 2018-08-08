package services.classes;

import entities.ProductByRecipe;
import entities.UserInfo;
import repositories.ProductByRecipeRepository;
import repositories.UserInfoRepository;
import services.Interfaces.ProductByRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Long createIdProductByRecipe(Long idRecipe) {
        return null;
    }

    @Override
    public Long provideIdProductByRecipe(ProductByRecipe productByRecipe) {
        return null;
    }

    @Override
    public ProductByRecipe provideProductByRecipe(Long idProductByRecipe) {
        return null;
    }

    @Override
    public void deleteProductByRecipe(Long idProductByRecipe) {

    }

    @Override
    public List<UserInfo> provideOffers(Long idProductByRecipe) {
        return null;
    }

    @Override
    public Long provideIdRecipe(Long idProductByRecipe) {
        return null;
    }

    @Override
    public Long provideIdFood(Long idProductByRecipe) {
        return null;
    }

    @Override
    public Long provideIdUserInfo(Long idProductByRecipe) {
        return null;
    }

    @Override
    public void clearFinalUserInfo(Long idProductByRecipe) {

    }

    @Override
    public void clearOffers(Long idProductByRecipe) {

    }
}
