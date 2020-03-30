package util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DBCPDemo {
    //  获取dbcp方式的ds对象,方式一：BasicDataSource
    public static DataSource getDataSourceWIthDBCP(){

        BasicDataSource dbcp = new BasicDataSource();
        dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dbcp.setUrl("jdbc:mysql://localhost:3306/test1?serverTimezone=UTC");
        dbcp.setUsername("root");
        dbcp.setPassword("123456");
        dbcp.setInitialSize(20);
        dbcp.setMaxActive(10);

        return dbcp;
    }
    //  获取dbcp方式的ds对象,方式一：BasicDataSource,   Properties
    public static DataSource getDataSourceWIthDBCPByProperties() throws Exception {

        DataSource dbcp = null;
        Properties props = new Properties();

        //   将    dbcpconfig.properties  文件加载到此类中

        //   将字符串  "dbcpconfig.properties"  转换为   输入流
        InputStream input = new DBCPDemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");

        //load方法中参数没有直接为字符串的，需要一个流的形式

        props.load(input);

        //  BasicDataSourceFactory  的返回值为DataSource   从dbcpconfig.properties文件中取到数据：
        //  driverClassName = com.mysql.cj.jdbc.Driver
        //url = jdbc:mysql://localhost:3306/test1?serverTimezone=UTC
        //username = root
        //password = 123456
        //initialSize = 20
        dbcp = BasicDataSourceFactory.createDataSource(props);

        return dbcp;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(DataSourceUtil.getDataSourceWIthDBCP().getConnection());
        System.out.println(getDataSourceWIthDBCPByProperties().getConnection());
    }

}
