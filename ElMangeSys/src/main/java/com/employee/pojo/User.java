package com.employee.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class User {
    @NotNull//不能为空
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore//把user返回成json字符串的时候把password忽略
    private String password;//密码
    @NotNull//不能为空
    private Integer  employeeId;//绑定的员工id
    private String role;//权限鉴定
}
