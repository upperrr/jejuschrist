package so.jejuschrist.DbConnectionTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import so.jejuschrist.domain.User;
import so.jejuschrist.mapper.UserMapper;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DbConnectionTest {
    private static final Logger logger = LoggerFactory.getLogger(DbConnectionTest.class);
    @Autowired
    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        // 테스트 시작 전에 동일한 id를 가진 사용자를 삭제
        userMapper.deleteById("tu12345");
    }

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

        logger.debug("Inserting user: {}", user);
        userMapper.insertUser(user);

        // 삽입 후 id 출력
        logger.debug("Finding user by id: {}", user.getId());

        User foundUser = userMapper.findById(user.getId());
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo(user.getUsername());
    }

}
