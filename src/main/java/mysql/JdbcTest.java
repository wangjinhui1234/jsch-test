package mysql;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/atguigudb";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        Connection connect = driver.connect(url, properties);
        System.out.println("方式二：" + connect);
    }

    @Test
    public void jdbcTest3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/atguigudb";
        String user = "root";
        String passwd = "root";

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, passwd);
        System.out.println("第三种方式" + connection);

    }

    @Test
    public void jdbcTest4() throws ClassNotFoundException, SQLException {
        //使用反射加载了Driver 类
        //在加载Driver类，完成注册
        // Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigudb";
        String user = "root";
        String passwd = "root";
        Connection connection = DriverManager.getConnection(url, user, passwd);
        System.out.println("第四种方式" + connection);
    }

    //方式5，在方式4的基础上改进，
    @Test
    public void jdbcTest5() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        //获取相关值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

}
