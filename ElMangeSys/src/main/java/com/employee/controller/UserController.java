package com.employee.controller;

import com.employee.pojo.Result;
import com.employee.pojo.User;
import com.employee.service.UserService;
import com.employee.utils.JwtUtil;
import com.employee.utils.Md5Util;
import com.employee.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated//值校验
public class UserController {
    @Autowired
    private UserService userService;
    //注入redis
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    //注册用户
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password,Integer employeeID){
        //查询用户

        System.out.println(username);
        System.out.println(password);
        System.out.println(employeeID);
        User u=userService.findByUserName(username);

        if(u==null){
            userService.register(username,password,employeeID);
            return Result.success();
            //注册
        }else {
            return Result.error("用户名被占用，请重新输入");
            //不注册
        }
    }

    //登录
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){
        //根据用户名查用户
        User loginUser=userService.findByUserName(username);
        //判断用户是否存在
        if (loginUser==null){
            return Result.error("用户不存在");
        }
        //判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            claims.put("employeeId",loginUser.getEmployeeId());
            String token= JwtUtil.genToken(claims);
            //把token存储到redis
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            stringStringValueOperations.set(token,token,1, TimeUnit.HOURS);

            return Result.success(token);
        }
        return Result.error("密码错误");

    }

    //获取用户信息
    @GetMapping("/userInfo")
    public Result<User> userInfo(){
        Map<String,Object> map=ThreadLocalUtil.get();
        String username=(String) map.get("username");
        User user=userService.findByUserName(username);
        return Result.success(user);
    }

    //修改密码
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> pararms, @RequestHeader("Authorization") String token){
        String oldPwd=pararms.get("old_pwd");
        String newPwd=pararms.get("new_pwd");
        String rePwd=pararms.get("re_pwd");

        Map<String,Object> map= ThreadLocalUtil.get();
        String username=(String) map.get("username");
        User user=userService.findByUserName(username);

        //检测三个密码是否为空
        if (!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要的参数");
        }
        //判断新旧密码是否一样
        if(oldPwd.equals(newPwd)){
            return Result.error("新密码不能与原密码一致");
        }
        //把原密码加密成MD5
        oldPwd=Md5Util.getMD5String(oldPwd);

        //如果原密码与正确密码不一致
        if(!oldPwd.equals(user.getPassword())){
            return Result.error("原密码输入错误");
        }
        //判断两次密码是否一样
        if(!newPwd.equals(rePwd)){
            return Result.error("确认密码与新密码不一致");
        }
        userService.updatePwd(newPwd);

        //删除redis对应的token
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.getOperations().delete(token);

        return Result.success();
    }
}
