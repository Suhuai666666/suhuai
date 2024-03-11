package com.employee.service;

import com.employee.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password,Integer employeeID);
    void updatePwd(String newPwd);
}
