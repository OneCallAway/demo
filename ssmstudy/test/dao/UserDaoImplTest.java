package dao;

import dao.Impl.UserDaoImpl;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.Date;

public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    //此方法是在testFindUserById之前执行的
    @BeforeMethod
    public void setUp() throws Exception {
        //创建sqlsessionfactory

        //获取mybatis配置文件
        String resource = "config/SqlMapConfig.xml";

        //得到配置流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindUserById() throws Exception {
        //创建userdao的对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        //调用userdao的方法
        User user = userDao.findUserById(4);

        System.out.println(user);
    }

    @Test
    public void testInsertUser() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        User user = new User();
        user.setName("asd");
        user.setBirthday(new Date());
        user.setAge(25);

        userDao.insertUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        userDao.deleteUser(1);
    }
}