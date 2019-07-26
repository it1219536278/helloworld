package com.czxy.service;

import com.czxy.domain.Log;
import com.czxy.domain.User;

public interface UserService {
    User login(User user);

    void addLog(Log log);
}
