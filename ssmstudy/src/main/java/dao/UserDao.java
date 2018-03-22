package dao;

import entity.User;

import java.util.List;

public interface UserDao {

    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //根据用户查找信息
    public List<User> findUserByName(String name) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;
}
