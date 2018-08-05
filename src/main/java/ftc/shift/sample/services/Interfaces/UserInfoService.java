package ftc.shift.sample.services.Interfaces;

import ftc.shift.sample.entities.UserInfo;
import lombok.NonNull;

public interface UserInfoService {

    //IllegalArgumentException("Вы ввели неправильный пароль")
    //IllegalArgumentException("Пользователя с таким логином не существует")
    //UserValidInfo createToken(@NonNull UserLogin userLogin);

    //IllegalArgumentException("Пользователя с таким логином не существует")
    //void deleteToken(@NonNull UserValidInfo userValidInfo);

    //Boolean checkAccess(@NonNull UserValidInfo userValidInfo);

    //UserInfo provideUserInfo(@NonNull String idUser);

    //UserInfo updateUserInfo(@NonNull UserInfo userInfo);

    //IllegalArgumentException("Этот логин уже существует")
    //void registration(@NonNull UserLogin userLogin);

    //void deleteUser(@NonNull String idUser);

    //IllegalArgumentException("Пользователя с таким логином не существует")
    //void updatePassword(@NonNull String idUser, @NonNull String newPassword);

    void createUser(@NonNull UserInfo userInfo);
}
