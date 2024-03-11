package com.employee.mapper;
import com.employee.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    //根据名字查找用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    //添加用户
    @Insert("insert into user(username,password,employee_ID)" +
            " values(#{username},#{password},#{employeeID})")
    void add(String username, String password,Integer employeeID);

    //修改密码
    @Update("update user set password=#{newPwd} where id=#{id}")
    void updatePwd(String newPwd,Integer id);
}
