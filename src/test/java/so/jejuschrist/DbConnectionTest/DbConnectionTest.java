package so.jejuschrist.DbConnectionTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import so.jejuschrist.domain.User;
import so.jejuschrist.mapper.UserMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DbConnectionTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertAndFindById() {
        User user = new User();
        user.setId("tu12345");
        user.setUsername("testUser");
        user.setPassword("password");
        user.setEmail("test@example.com");
        user.setCreatedAt(java.time.LocalDateTime.now());
        user.setUpdatedAt(java.time.LocalDateTime.now());
        user.setLastLogin(java.time.LocalDateTime.now());
        user.setStatus("ACTIVE");

        userMapper.insertUser(user);

        // 삽입 후 user_code 출력
        System.out.println("Inserted user_code: " + user.getUser_code());

        User foundUser = userMapper.findById(user.getUser_code());
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo(user.getUsername());
    }

}
