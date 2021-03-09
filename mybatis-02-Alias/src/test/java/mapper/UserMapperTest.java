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
}