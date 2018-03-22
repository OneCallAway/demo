package mapper;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

import static org.testng.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @BeforeMethod
    public void setUp() throws Exception {
        //创建会话工厂

        //mybatis配置文件
        String resource = "config/SqlMapConfig.xml";

        //获取流
        InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);

        //创建回话工厂，传入mybatis配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用usermapper的方法
        User user = userMapper.findUserById(2);

        sqlSession.close();

        System.out.println(user);
    }
    @Test
    public void testFindUserByName() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = userMapper.findUserByName("qwe");

        sqlSession.close();

        System.out.println(list);
    }
}