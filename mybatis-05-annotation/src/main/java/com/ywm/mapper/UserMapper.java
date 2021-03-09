package com.ywm.mapper;

import com.ywm.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//这里用mapper 等价于我以前用的Dao 以后都会用mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    // 方法存在多个参数，所有参数前面必须加上 @Param
    @Select("select * from user where id = #{id} and name = #{name}")
    User getUserByIdAndName(@Param("id") int id, @Param("name") String name);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name},#{password})")
    int addUser(User user);

}