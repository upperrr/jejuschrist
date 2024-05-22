package so.jejuschrist.mapper;

import org.apache.ibatis.annotations.Mapper;
import so.jejuschrist.domain.User;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findById(String id);
    void deleteById(String id);
}
