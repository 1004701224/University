package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceUtil {
    //c3p0  硬编码的方式
    public static DataSource getDataSourceWithC3P0(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("com.mysql.cj.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:mysql://localhost:3306/test1?serverTimezone=UTC");
        c3p0.setUser("root");
        c3p0.setPassword("123456");

        return c3p0 ;
    }

    //  c3p0  的xml方式获取dataSource
    public static DataSource getDataSourceWithC3P0ByXml(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("yyf");
        return c3p0 ;
    }

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

}
