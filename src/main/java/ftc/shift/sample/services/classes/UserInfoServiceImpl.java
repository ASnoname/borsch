package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.Recipe;
import ftc.shift.sample.entities.UserInfo;
import ftc.shift.sample.entities.enums.StateByProduct;
import ftc.shift.sample.repositories.UserInfoRepository;
import ftc.shift.sample.services.Interfaces.UserInfoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImpl(final UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public Long createUserInfo() {

        UserInfo userInfo = new UserInfo();
        userInfoRepository.save(userInfo);
        return userInfo.getId();
    }

    @Override
    public void deleteUserInfo(@NonNull Long idUserInfo) {

        userInfoRepository.deleteById(idUserInfo);
    }

    @Override
    public UserInfo provideUserInfo(@NonNull Long idUserInfo) {

        return userInfoRepository
                .findById(idUserInfo)
                .get();
    }

    @Override
    public Collection<Recipe> getAllRecipesByUserInfo(@NonNull Long idUserInfo) {

        return userInfoRepository
                .findById(idUserInfo)
                .get()
                .getRecipes();
    }

    @Override
    public Map<Long, StateByProduct> getStatesForProductByRecipe(@NonNull Long idUserInfo) {

        return userInfoRepository
                .findById(idUserInfo)
                .get()
                .getStateByProductMap();
    }
}