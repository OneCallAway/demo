import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Mybatis {
    //跟据id查询用户信息，得到一个记录结果

    //mybatis配置文件
    String resource = "config/SqlMapConfig.xml";

    @Test
    public void findUserByIdTest() throws IOException {

        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream ( resource );

        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFacory = new SqlSessionFactoryBuilder ( ).build ( inputStream );

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFacory.openSession ( );

        //通过sqlsession操作数据库
        //第一个参数：映射文件中statement的id，等于namespace+“。”+statement的id
        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        //sqlSessionOne.selectOne结果是与映射文件中所匹配的resultType类型的对象
        User user = sqlSession.selectOne ( "test.findUserById", 7 );

        System.out.println ( user );

        //释放资源
        sqlSession.close ( );
    }

    @Test
    public void findUserByNameTest() throws IOException {
        //获取流
        InputStream inputSteam = Resources.getResourceAsStream ( resource );
        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ( ).build ( inputSteam );

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession ( );

        //通过sqlsession操作数据库
        List<User> list = sqlSession.selectList ( "test.findUserByName", "wer" );

        System.out.println ( list );

        //释放资源
        sqlSession.close ( );
    }

    //添加用户信息
    @Test
    public void insertUserTest() throws IOException {
        //获取流
        InputStream inputStream = Resources.getResourceAsStream ( resource );

        //创建会话工厂，传入mybatis配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build ( inputStream );

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession ();

        //插入用户对象
        User user = new User ();
        user.setName("zxc");
        user.setBirthday(new Date ());
        user.setAge(10);

        //
        sqlSession.insert ( "test.insertUser",user );

        System.out.printf ( String.valueOf ( user.getId () ) );

        //提交事务
        sqlSession.commit ();

        //释放资源
        sqlSession.close ();
    }

    @Test
    public void delectUserTest() throws IOException {
        //获取流
        InputStream inputStream = Resources.getResourceAsStream ( resource );

        //创建会话工厂，传入mybatis配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build ( inputStream );

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession ();

        //传入id删除用户
        sqlSession.delete ( "test.deleteUser",16 );

        //提交事务
        sqlSession.commit ();

        //释放资源
        sqlSession.close ();
    }

    @Test
    public void UpdateUserTest() throws IOException {
        //获取流
        InputStream inputStream = Resources.getResourceAsStream ( resource );

        //创建会话工厂，传入mybatis配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build ( inputStream );

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession ();

        //更新用户信息
        User user = new User ();

        //更新用户信息必须设置id
        user.setId ( 12 );
        user.setName ( "mnb" );
        user.setBirthday ( new Date (  ) );
        user.setAge ( 45 );

        sqlSession.update ( "test.updateUser",user);

        //提交事务
        sqlSession.commit ();

        //释放资源
        sqlSession.close ();

    }
}

