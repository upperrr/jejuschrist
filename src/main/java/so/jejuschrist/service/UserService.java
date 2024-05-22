package so.jejuschrist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import so.jejuschrist.domain.User;
import so.jejuschrist.mapper.UserMapper;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public  void registerUser(User user) {
        userMapper.insertUser(user);
    }
}
