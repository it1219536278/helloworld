package com.czxy.service.impl;

import com.czxy.dao.LogMapper;
import com.czxy.dao.UserMapper;
import com.czxy.domain.Log;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;

    @Override
    public User login(User user) {
        List<User> users = userMapper.selectAll();
        for (User user1 : users) {
            if (user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword())){
                return user1;
            }
        }
        return null;
    }

    @Override
    public void addLog(Log log) {
        logMapper.insert(log);
    }
}
