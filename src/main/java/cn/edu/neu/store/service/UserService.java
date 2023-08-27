package cn.edu.neu.store.service;

import cn.edu.neu.store.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户业务层接口
 */
@Service
public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    User existsUser(User user);

    boolean regUser(User user);

    List<User> getUserList(User user);//task7查询用户信息，存到list里

    User getUser(String userid);

    boolean updateUser(User user);

    boolean deleteUser(User user);

    int addUser(User user);

    User getUserById(Integer id);

    Map<String, Integer> getUserGenderRatio();

    User getSearch(String username);
}
