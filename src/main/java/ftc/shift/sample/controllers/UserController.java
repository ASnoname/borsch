//package ftc.shift.sample.controllers;
//
//import ftc.shift.sample.entities.UserInfo;
//import ftc.shift.sample.entities.UserLogin;
//import ftc.shift.sample.entities.UserValidInfo;
//import ftc.shift.sample.services.Interfaces.UserInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//public class UserController {
//
//    private static final String USERS_PATH = Resources.API_PREFIX + "users";
//
//    private final UserInfoService services;
//
//    @Autowired
//    public UserController(UserInfoService services) {
//        this.services = services;
//    }
//
//    @PostMapping(USERS_PATH+"/registration")
//    public @ResponseBody
//    BaseResponse createUser(@RequestBody UserLogin userLogin) {
//        BaseResponse response = new BaseResponse();
//        services.registration(userLogin);
//        return response;
//    }
//
//    @PostMapping(USERS_PATH+"/login"+"/{userName}")
//    public @ResponseBody
//    BaseResponse<UserValidInfo> loginUser(@RequestBody UserLogin userLogin) {
//        BaseResponse<UserValidInfo> response = new BaseResponse<>();
//        UserValidInfo token = services.createToken(userLogin);
//        response.setData(token);
//        return response;
//    }
//
//    @GetMapping(USERS_PATH+"/id{userName}")
//    public @ResponseBody
//    BaseResponse<UserInfo> createUser(@PathVariable String userName,final HttpServletRequest request) {
//        BaseResponse<UserInfo> response = new BaseResponse<>();
//        UserInfo info = services.provideUserInfo(userName);
//        response.setData(info);
//        return response;
//    }
//
//    @PatchMapping(USERS_PATH)
//    public @ResponseBody
//    BaseResponse<UserInfo> updateBook(final HttpServletRequest request, @RequestBody UserInfo info) {
//        BaseResponse<UserInfo> response = new BaseResponse<>();
//        String userName = request.getHeader("Login");
//        UserInfo result = services.updateUserInfo(info);
//        response.setData(result);
//        return response;
//    }
//    @GetMapping(USERS_PATH+"/logout"+"/{userName}")
//    public @ResponseBody
//    BaseResponse<UserInfo> logoutUser(@PathVariable String userName,final HttpServletRequest request) {
//        BaseResponse<UserInfo> response = new BaseResponse<>();
//        UserValidInfo userValidInfo = new UserValidInfo();
//        userValidInfo.setId(userName);
//        userValidInfo.setToken(request.getHeader("Token"));
//        services.deleteToken(userValidInfo);
//        return response;
//    }
//}


