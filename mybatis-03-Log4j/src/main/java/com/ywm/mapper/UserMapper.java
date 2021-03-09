package com.ywm.mapper;

import com.ywm.pojo.User;

import java.util.List;

//这里用mapper 等价于我以前用的Dao 以后都会用mapper
public interface UserMapper {
    // 根据ID查询用户
    User getUserById(int id);

}