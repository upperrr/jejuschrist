package so.jejuschrist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import so.jejuschrist.domain.User;
import so.jejuschrist.mapper.UserMapper;

@Service
public class UserService {
    private final UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void registerUser(User user) throws Exception {
        try {
            // 사용자 등록 로직
            userMapper.insertUser(user);
            logger.info("★★★★ Registering user in UserService: {}", user);
        } catch (Exception e) {
            logger.error("★★★★ Error in UserService while registering user: {}", user, e);
            throw e; // 예외를 다시 던져 Controller에서 처리하게 함
        }
    }
}
