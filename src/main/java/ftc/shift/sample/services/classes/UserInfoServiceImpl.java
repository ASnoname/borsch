package ftc.shift.sample.services.classes;

import ftc.shift.sample.entities.UserInfo;
import ftc.shift.sample.repositories.UserInfoRepository;
import ftc.shift.sample.services.Interfaces.UserInfoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImpl(final UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


//
//    private String generateToken(@NonNull String characters) {
//
//        Random random = new Random();
//        char[] text = new char[characters.length()];
//        for (int i = 0; i < characters.length(); i++) {
//            text[i] = characters.charAt(random.nextInt(characters.length()));
//        }
//        return new String(text);
//    }

//    @Override
//    public UserValidInfo createToken(@NonNull UserLogin userLogin) {
//
//        if (!provideUser(userLogin.userName).getPassword().equals(userLogin.getPassword())) {
//            throw new IllegalArgumentException("Вы ввели неправильный пароль");
//        }
//
//        UserValidInfo userValidInfo = new UserValidInfo();
//        userValidInfo.setToken(generateToken(userLogin.getPassword().concat(userLogin.userName)));
//        userValidInfo.setId(userLogin.getUserName());
//        tokenRepository.addToken(userValidInfo);
//        return userValidInfo;
//    }

//    @Override
//    public void deleteToken(@NonNull UserValidInfo userValidInfo) {
//
//        if (userRepository.getAllUsers().containsKey(userValidInfo.getId())) {
//            if (tokenRepository.getAllTokensUser(userValidInfo.getId()).contains(userValidInfo.getToken())) {
//                tokenRepository.deleteToken(userValidInfo);
//            } else {
//                throw new IllegalArgumentException("Токена с таким пользователем не существует");
//            }
//        } else {
//            throw new IllegalArgumentException("Пользователя с таким логином не существует");
//        }
//    }

//    @Override
//    public Boolean checkAccess(@NonNull UserValidInfo userValidInfo) {
//
//        for (String token : tokenRepository.getAllTokensUser(userValidInfo.getId())) {
//            if (token.equals(userValidInfo.getToken()))
//                return true;
//        }
//        return false;
//    }

//    @Override
//    public UserInfo provideUserInfo(@NonNull String idUser) {
//
//        return userInfoRepository.;
//    }
//
//    @Override
//    public UserInfo updateUserInfo(@NonNull UserInfo userInfo) {
//
//        provideUser(userInfo.getId()).setUserInfo(userInfo);
//        return updateUser(provideUser(userInfo.getId())).getUserInfo();
//    }

//    @Override
//    public void registration(@NonNull UserLogin userLogin) {
//
//        if (userRepository.getAllUsers().containsKey(userLogin.getUserName())) {
//            throw new IllegalArgumentException("Этот логин уже существует");
//        } else {
//            User user = new User();
//            user.setLogin(userLogin.getUserName());
//            user.setPassword(userLogin.getPassword());
//            UserInfo userInfo = new UserInfo();
//            Fridge fridge = new Fridge();
//            user.setFridge(fridge);
//            userInfo.setId(userLogin.getUserName());
//            user.setUserInfo(userInfo);
//            createUser(user);
//        }
//    }

//    @Override
//    public void updatePassword(@NonNull String idUser, @NonNull String newPassword) {
//
//        provideUser(idUser).setPassword(newPassword);
//        updateUser(provideUser(idUser));
//    }

//    private User provideUser(@NonNull String idUser) {
//
//        if (userRepository.getAllUsers().containsKey(idUser))
//            return userRepository.fetchUser(idUser);
//        else throw new IllegalArgumentException("Пользователя с таким логином не существует");
//    }
//
//    private User updateUser(@NonNull User user) {
//
//        userRepository.updateUser(user);
//        return user;
//    }

//    @Override
//    public void deleteUser(@NonNull String idUser) {
//
//        if (userRepository.getAllUsers().containsKey(idUser)) {
//            userRepository.deleteUser(idUser);
//        } else {
//            throw new IllegalArgumentException("Вы пытаетесь удалить несуществующего пользователя");
//        }
//    }

    public void createUser(@NonNull UserInfo userInfo) {

        userInfoRepository.save(userInfo);
    }
}