package cn.edu.neu.store.service.impl;

import cn.edu.neu.store.mapper.UserMapper;
import cn.edu.neu.store.model.User;
import cn.edu.neu.store.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户业务层实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User existsUser(User user) {
        return userMapper.existsUser(user);
    }

    @Override
    public boolean regUser(User user) {
        try {
            userMapper.addUser(user);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }

    //修改按钮点击
    @Override
    public User getUser(String userid) {
        // TODO Auto-generated method stub
        return userMapper.getUser(userid);
    }
    //新页面用户修改后点击提交
    @Override
    public boolean updateUser(User user) {
        try {
            userMapper.updateUser(user);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(User user) {
        // TODO Auto-generated method stub
        try {
            userMapper.deleteUser(user);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int addUser(User user) {
        try {
            userMapper.addUser(user);
            return 0;
        }catch(Exception e) {
            e.printStackTrace();
            return 2;
        }
    }

    @Override
   public User getUserById(Integer id){
        User user = userMapper.getUserById(id);
        return  user;
    }

    public Map<String, Integer> getUserGenderRatio() {
        int maleCount = userMapper.countByGender(0);
        int femaleCount = userMapper.countByGender(1);
        System.out.println("maleCount:"+maleCount+",femaleCount"+femaleCount);
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("male", maleCount);
        resultMap.put("female", femaleCount);
        return resultMap;
    }

    @Override
    public User getSearch(String username) {
        return userMapper.getSearch(username);
    }

}
