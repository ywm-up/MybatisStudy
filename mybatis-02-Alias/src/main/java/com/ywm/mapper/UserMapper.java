package com.ywm.mapper;

import com.ywm.pojo.User;

import java.util.List;

//这里用mapper 等价于我以前用的Dao 以后都会用mapper
public interface UserMapper {
    // 获取全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

    // insert 一个用户
    int addUser(User user);

    // 修改一个用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUser(int id);
}