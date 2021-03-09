package mapper;

import com.ywm.mapper.UserMapper;
import com.ywm.pojo.User;
import com.ywm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;


public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void test() {
        // 第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            sqlSession = MybatisUtils.getSqlSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(2);

            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4J");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了Log4j");
    }
}