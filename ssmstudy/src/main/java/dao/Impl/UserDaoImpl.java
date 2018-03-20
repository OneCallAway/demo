package dao.Impl;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSessionFactory;


public class UserDaoImpl implements UserDao {

    /**
     * 需要向dao实现类中注入sqlsessionfactory
     * 需要构造方法注入
     */
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) throws Exception {
        return null;
    }

    public void insertUser(User user) throws Exception {

    }

    public void deleteUser(int id) throws Exception {

    }
}
