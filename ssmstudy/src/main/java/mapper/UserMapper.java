package mapper;

import entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * mapper接口
     * 1:在mapper.xml中namespace等于mapper接口地址
     * 2:mapper.java接口中的方法名和mapper.xml中statement的id一致
     * 3:mapper.java接口中方法的输入参数类型和mapper.xml中parameterType指定的类型一致
     * 4:mapper.java接口中方法的输出参数类型和mapper.xml中resultType指定的类型一致
     */

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String name) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;

//    public User findUserById(int id) throws Exception;
//
//    public List<User> findUserByName(String name) throws Exception;
//

//    public void insertUser(User user) throws Exception;
//

//    public void deleteUser(int id) throws Exception;
}
