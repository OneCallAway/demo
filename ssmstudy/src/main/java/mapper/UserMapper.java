package mapper;

import entity.User;
import entity.UserCustom;
import entity.UserQueryVo;
import org.apache.ibatis.annotations.Param;

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

    //用户信息的综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //用户综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    //
    public User findUserByIdResultMap(int id) throws Exception;
}
