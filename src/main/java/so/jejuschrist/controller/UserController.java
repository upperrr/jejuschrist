package so.jejuschrist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import so.jejuschrist.domain.User;
import so.jejuschrist.service.UserService;

@RestController
//@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/register")
//    public void registerUser(@RequestBody User user) {
//        userService.registerUser(user);
//    }

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody User userData) {
//        try {
//            userService.registerUser(userData);
//            return ResponseEntity.ok("User registered successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error registering user: " + e.getMessage());
//        }
@PostMapping("/user/register")
public ResponseEntity<?> registerUser(@RequestBody User userData) {
    // 사용자 등록 로직
    // 성공적으로 사용자가 등록되면 아래와 같이 JSON 응답을 반환
    return ResponseEntity.ok().body("{\"message\":\"User registered successfully\"}");
}
    }

