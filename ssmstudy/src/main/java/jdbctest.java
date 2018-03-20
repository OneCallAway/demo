import java.sql.*;

public class jdbctest {
    public static void main(String[] args) {
        //数据库链接
        Connection connection = null;
        //预编译的statement,使用预编译的statement提高数据库性能
        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName ( "com.mysql.jdbc.Driver" );

            //通过数据库驱动获取数据库连接
            connection = DriverManager.getConnection ("" );

            //定义sql语句
            String sql = "select * from user where name = ?";
            //获取比预编译的statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号，第二个参数为设置的参数值
            preparedStatement.setString (  1,"ty");
            //向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果集，
            while(resultSet.next ())
            {
                System.out.printf ( resultSet.getString("id") + "" +resultSet.getString("name") );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }
}
