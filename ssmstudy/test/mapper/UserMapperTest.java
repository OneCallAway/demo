package mapper;

import entity.User;
import entity.UserCustom;
import entity.UserQueryVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.ArrayList;
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
    public void testFindUserByIdResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用usermapper的方法
        User user = userMapper.findUserByIdResultMap(2);

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

    @Test
    public void testFindUserList() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        /**
         * 由于使用了动态sql，如果不设置某个值，条件不会拼接在sql中
         * //userCustom.setAge(25);
         * select * from student where student.name like '%${userCustom.name}%'
         *
         * userCustom.setName("ad");
         * select * from student where student.age = #{userCustom.age}
         *
         */
        userCustom.setAge(25);
        userCustom.setName("ad");

        //传入多个id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        //将ids通过userQueryVo传入statement中
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);

        //调用usermapper方法
        List<UserCustom> list = userMapper.findUserList(userQueryVo);

        sqlSession.close();

        System.out.println(list);
    }

    @Test
    public void testFindUserCount() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setAge(25);
        userCustom.getName("ad");
        userQueryVo.setUserCustom(userCustom);

        //调用usermapper方法
        int count = userMapper.findUserCount(userQueryVo);

        sqlSession.close();

        System.out.println(count);
    }
}