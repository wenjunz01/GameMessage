package cn.edu.neu.store.mapper;

import cn.edu.neu.store.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User existsUser(User user);

    boolean regUser(User user);

    List<User> getUserList(User user);

    User getUser(String userid);

    void updateUser(User user);

    boolean deleteUser(User user);

    boolean addUser(User user);

    User getUserById(Integer id);

    int countByGender(int user_sex);

    User getSearch(String username);

}
