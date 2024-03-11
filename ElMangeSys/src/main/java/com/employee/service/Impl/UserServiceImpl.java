package com.employee.service.Impl;

import com.employee.mapper.UserMapper;
import com.employee.pojo.User;
import com.employee.service.UserService;
import com.employee.utils.Md5Util;
import com.employee.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        User u=userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password,Integer employeeID) {
        //对密码进行加密
        String psw= Md5Util.getMD5String(password);
        userMapper.add(username,psw,employeeID);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer) map.get("id");
        String npwd=Md5Util.getMD5String(newPwd);
        userMapper.updatePwd(npwd,id);
    }
}
