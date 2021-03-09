package mapper;

import com.ywm.mapper.UserMapper;
import com.ywm.pojo.User;
import com.ywm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserMapperTest {
    @Test
    public void test() {
        // 第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            sqlSession = MybatisUtils.getSqlSession();
            // 执行SQL
            // 方法一：getMapper 建议使用
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            // 方法二: 记住有这个方法就行
            // List<User> userList = sqlSession.selectList("mapper.UserMapper.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        // 第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 获取 mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 拿到对象
        User user = mapper.getUserById(2);
        // 输出
        System.out.println(user);

        // 关闭SqlSession
        sqlSession.close();
    }

    // 增删改需要提交事务
    @Test
    public void addUser(){
        // 第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 获取 mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 拿到对象

        int res = mapper.addUser(new User(6,"哈哈","123123"));
        if (res > 0) {
            System.out.println("插入成功");
        }

        // 必须要写提交事务，才能插入成功
        sqlSession.commit();

        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(7,"呵呵","123123123"));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(1);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        // 第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 获取 mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 拿到对象
        List<User> userList = mapper.getUserLike("%哈%");

        for (User user : userList) {
            System.out.println(user);
        }


        // 关闭SqlSession
        sqlSession.close();
    }
}