package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.ProductByFridge;
import ftc.shift.sample.repositories.UserInfoRepository;
import ftc.shift.sample.services.Interfaces.FridgeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FridgeServiceImpl implements FridgeService {

    private final UserInfoRepository userInfoRepository;

    @Autowired
    public FridgeServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public void createProductByFridge(@NonNull Long idUserInfo, @NonNull ProductByFridge productByFridge) {

        userInfoRepository.findById(idUserInfo).get().getFridge().getProducts().add(productByFridge);

        productByFridge.setFridge(userInfoRepository.findById(idUserInfo).get().getFridge());
    }

    @Override
    public Collection<ProductByFridge> provideAllProductByFridge(@NonNull Long idUserInfo) {

        return userInfoRepository.findById(idUserInfo).get().getFridge().getProducts();
    }
}